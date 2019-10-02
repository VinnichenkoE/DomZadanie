package graduation_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Storage {
    private List<Good> list = new ArrayList();
    private List<Register> registerList = new ArrayList<>();
    private final double CAPACITY = 100.0;
    private String input = "";
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<String> operations = new ArrayList<>() {
        {
            add("Выберите операцию: ");
            add("1. Провести инвентаризацию");
            add("2. Принять товар");
            add("3. Отгрузить товр");
            add("4. Просмотреть журнал поступления-отпуска");
            add("5. Выход");
        }
    };
    private boolean exit = true;
    private String SQL = "";
    private DBWorker dbWorker = new DBWorker();
    private Connection connection = dbWorker.getConnection();


    public void addGood(int id, String name, double quantity) {
        list.add(new Good(id, name, quantity));
    }

    public String getInput() {
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public void goodsToList() throws SQLException {
        SQL = "select * from goods";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double quantity = resultSet.getDouble("quantity");
            addGood(id, name, quantity);
        }
    }

    public void makeAnInventory() throws SQLException {
            goodsToList();
            list.forEach(e -> System.out.println(e.toString()));
            list.clear();
        }

    public boolean isCapacityEnaught(double quantity) throws SQLException {
        return quantity + totalQuantityOfGoods() <= CAPACITY;
    }

    public double totalQuantityOfGoods() {
        return list.stream().mapToDouble(e -> e.getQuantity()).sum();
    }
    public void insertIntoRegister(int id, String contractor, Date date, double quantity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into register (id_good, contractor, date, quantity) values (?,?,?,?);");
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2, contractor);
        preparedStatement.setDate(3, date);
        preparedStatement.setDouble(4, quantity);
        preparedStatement.execute();
    }
    public int getIdByName(String name) {
        return list.stream().filter(e->e.getName().equals(name)).findFirst().get().getId();
    }

    public void addGoodAtStorage() throws SQLException {
        System.out.println("Введите наименование товара: ");
        String name = getInput();
        System.out.println("Введите количество товара: ");
        double quantity = Double.parseDouble(getInput());
        goodsToList();
        if (isCapacityEnaught(quantity)) {
            System.out.println("Введите поставщика: ");
            String contractor = getInput();
            System.out.println("Введите дату поставки: ");
            Date date = Date.valueOf(getInput());
            if (isGoodInStorageList(name)) {
                insertIntoRegister(getIdByName(name), contractor,date,quantity);
                quantity += getQuantityFromList(name);
                setQuantityInDB(quantity, name);
            } else {
                list.clear();
                SQL = "insert into goods values (null,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                preparedStatement.setString(1, name);
                preparedStatement.setDouble(2, quantity);
                preparedStatement.execute();
                goodsToList();
                insertIntoRegister(getIdByName(name), contractor, date, quantity);
            }
        } else System.out.println("Недостаточно места на складе!");
        list.clear();
    }

    public boolean isGoodInStorageList(String name) throws SQLException {
        return list.stream().anyMatch(e -> e.getName().equals(name));
    }
    public void setQuantityInDB(Double quantity, String name) throws SQLException {
        SQL = "update goods set quantity = ? where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setDouble(1, quantity);
        preparedStatement.setString(2, name);
        preparedStatement.executeUpdate();
    }
    public Double getQuantityFromList(String name){
        return list.stream().filter(e->e.getName().equals(name)).findFirst().get().getQuantity();
    }
    public void shipFromStorage() throws SQLException {
        System.out.println("Введите наименование товара: ");
        String name = getInput();
        goodsToList();
        if (isGoodInStorageList(name)){
            System.out.println("Введите количество: ");
            double quantity = Double.parseDouble(getInput());
            if(getQuantityFromList(name)>= quantity){
                double quantityToDB = getQuantityFromList(name) - quantity;
                setQuantityInDB(quantityToDB,name);
                quantity = -quantity;
                System.out.println("Введите получателя: ");
                String contractor = getInput();
                System.out.println("Введите дату отгрузки: ");
                Date date = Date.valueOf(getInput());
                insertIntoRegister(getIdByName(name), contractor, date,quantity);
            } else System.out.println("Недостаточно товара");
        } else System.out.println("Такого товара нет на складе");
        list.clear();
    }
    public void lookInRegister() throws SQLException {
        System.out.println("Введите нпименование товара: ");
        String name = getInput();
        SQL = "select r.contractor, r.date, r.quantity from register r join goods g on (g.id = r.id_good) where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String contractor = resultSet.getString("contractor");
            double quantity = resultSet.getDouble("quantity");
            Date date = resultSet.getDate("date");
            addRegister(contractor, quantity,date);
        }
        registerList.forEach(e -> System.out.println(e.toString()));
        registerList.clear();

    }
    public void addRegister(String conrtactor, double quantity, Date date){
        registerList.add(new Register(conrtactor,quantity, date));
    }

    public void start() throws SQLException {
        while (exit) {

            operations.stream().forEach(System.out::println);

            switch (getInput()) {
                case "1":
                    makeAnInventory();
                    break;
                case "2":
                    addGoodAtStorage();
                    break;
                case "3":
                    shipFromStorage();
                    break;
                case "4":
                    lookInRegister();
                    break;
                case "5":
                    System.out.println("До свидания");
                    exit = false;
                    break;


            }
        }
    }
}


