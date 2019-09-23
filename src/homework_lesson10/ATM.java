package homework_lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {

    String input = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void newSession() throws IOException {
        Bank bank = new Bank();
        bank.addClient(1,1000);
        bank.addClient(2,5000);
        bank.addClient(3,1500);
        System.out.println(bank.clients.toString());

        while (input != "exit") {
            System.out.println("Введите номер карты");
            int numberOfCard = Integer.parseInt(br.readLine());
            if (!(bank.checkClientExist(numberOfCard))) {
                System.out.println("Неверный номер карты");
            }
            System.out.println("Введите PIN: ");
            input = br.readLine();
            if (!(bank.checkPassword(Integer.parseInt(input)))){
                System.out.println("Неверный PIN: ");
            }
            System.out.println("Выберите операцию: ");
            System.out.println("1. Положить деньги на счет.");
            System.out.println("2. Снять деньги со счета.");
            System.out.println("3. Проверить отстаток.");
            System.out.println("4. Перевести деньги.");
            System.out.println("5. Выйти.");
            input = br.readLine();

            switch (input) {
                case "1":
                    System.out.println("Введите сумму: ");
                    String sum = br.readLine();
                    bank.clients.stream().filter(e->e.getNumberOfAccount() == numberOfCard).forEach(e->e.setMoneyOnAccount(e.getMoneyOnAccount()+Integer.parseInt(sum)));
                    break;
                case "2":
                    System.out.println("Введите сумму: ");
                    sum = br.readLine();
                    if (bank.checkMoneyIsEnaught(numberOfCard,Integer.parseInt(sum))){
                        bank.clients.stream().filter(e->e.getNumberOfAccount()==numberOfCard).forEach(e->e.setMoneyOnAccount(e.getMoneyOnAccount()-Integer.parseInt(sum)));
                    }else {
                        System.out.println("Недостаточно средств на счете");
                    }
                    break;
                case "3":
                    System.out.println("Ваш остаток: " + bank.clients.stream().filter(e->e.getNumberOfAccount()==numberOfCard).findFirst().get().getMoneyOnAccount());
                    break;
                case "4":
                    System.out.println("Введите номер счета на который вы хотите перевести деньги: ");
                    int numberOfAccounToPutMoney = Integer.parseInt(br.readLine());
                    System.out.println("Введите сумму: ");
                    sum = br.readLine();
                    if(bank.checkMoneyIsEnaught(numberOfCard,Integer.parseInt(sum))){
                        bank.clients.stream().filter(e->e.getNumberOfAccount()==numberOfCard).forEach(e->e.setMoneyOnAccount(e.getMoneyOnAccount()-Integer.parseInt(sum)));
                        bank.clients.stream().filter(e->e.getNumberOfAccount()==numberOfAccounToPutMoney).forEach(e->e.setMoneyOnAccount(e.getMoneyOnAccount()+Integer.parseInt(sum)));
                    }
                    else{
                        System.out.println("Недостаточно средств на сете: ");
                    }
                    break;
                case "5":
                    input = "exit";


            }
            System.out.println(bank.clients.toString());
        }




    }



}

