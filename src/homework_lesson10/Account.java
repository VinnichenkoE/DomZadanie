package homework_lesson10;

import java.util.Random;

public class Account {
    int moneyOnAccount;
    int numberOfAccount;
    int PIN;

    Random random = new Random();

    public Account(int numberOfAccount, int moneyOnAccount){
        this.numberOfAccount = numberOfAccount;
        this.moneyOnAccount = moneyOnAccount;
        this.PIN = random.nextInt(9999);
    }

    public int getMoneyOnAccount() {
        return moneyOnAccount;
    }

    public void setMoneyOnAccount(int moneyOnAccount) {
        this.moneyOnAccount = moneyOnAccount;
    }

    public int getNumberOfAccount() {
        return numberOfAccount;
    }

    public int getPIN() {
        return PIN;
    }



    @Override
    public String toString() {
        return "Account{" +
                "moneyOnAccount=" + moneyOnAccount +
                ", numberOfAccount=" + numberOfAccount +
                ", PIN=" + PIN +
                '}';
    }
}


