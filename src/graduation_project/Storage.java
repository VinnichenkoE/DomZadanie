package graduation_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Storage {
    private List<Good> list = new ArrayList();
    private final double CAPACITY = 100.0;
    private String input = "";
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<String> operations = new ArrayList<>() {
        {
            add("Выберите операцию: ");
            add("1. Провести инвентаризацию");
            add("2. Принять товар");
            add("3. Отгрузить товр");
            add("4. Выход");
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

    public void selectToList() throws SQLException {
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

    public double totalQuantityOfGoods() {
        return list.stream().mapToDouble(e -> e.getQuantity()).sum();
    }

    public boolean isGoodInStorageList(String name) {
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

    public void start() throws SQLException {
        while (exit) {

            operations.stream().forEach(System.out::println);

            switch (getInput()) {
                case "1":
                    selectToList();
                    list.forEach(e -> System.out.println(e.toString()));
                    list.clear();
                    break;
                case "2":
                    System.out.println("Введите наименование товара: ");
                    String name = getInput();
                    System.out.println("Введите количество");
                    double quantity = Double.parseDouble(getInput());
                    selectToList();
                    if (quantity + totalQuantityOfGoods() <= CAPACITY) {
                        if (isGoodInStorageList(name)) {
                            quantity  += getQuantityFromList(name);
                            setQuantityInDB(quantity,name);

                        } else {
                            SQL = "insert into goods values (null,?,?)";
                            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
                            preparedStatement.setString(1, name);
                            preparedStatement.setDouble(2, quantity);
                            preparedStatement.execute();
                        }

                    } else System.out.println("Товар не помещается на склад");
                    list.clear();
                    break;
                case "3":
                    System.out.println("Введите нпименование товара: ");
                    name = getInput();
                    selectToList();
                    if(isGoodInStorageList(name)){
                        System.out.println("Введите количество: ");
                        quantity = Double.parseDouble(getInput());
                        if(getQuantityFromList(name)>=quantity){
                            quantity = getQuantityFromList(name) - quantity;
                            setQuantityInDB(quantity, name);
                        }
                        else System.out.println("Недостаточно товара на складе\n На складе осталось " + getQuantityFromList(name) + " единиц " + name);
                    }else System.out.println("Такого товара нет на складе");
                    list.clear();
                    break;
                case "4":
                    System.out.println("До свидания");
                    exit = false;
                    break;


            }
        }
    }
}


