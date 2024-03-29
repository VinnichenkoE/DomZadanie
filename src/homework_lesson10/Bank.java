package homework_lesson10;

import java.util.ArrayList;

public  class Bank {
     ArrayList<Account> clients = new ArrayList<>();


    public void addClient(int numberOfAccount, int moneyOnAccount){
         Account account = new Account(numberOfAccount, moneyOnAccount);
         clients.add(account);
     }
     public boolean checkClientExist(int numberOfAccount){
         return  clients.stream().anyMatch(e -> e.getNumberOfAccount() == numberOfAccount);
     }
     public boolean checkPIN(int numberOfAccount, int PIN){
        return clients.stream().filter(e->e.getNumberOfAccount()==numberOfAccount).anyMatch(e-> e.getPIN()==PIN);
     }

     public boolean checkMoneyIsEnaught(int numberOfAccount, int sum){
        return clients.stream().filter(e->e.getNumberOfAccount() == numberOfAccount).anyMatch(e-> e.getMoneyOnAccount()>=sum);

     }


}



