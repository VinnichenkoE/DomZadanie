package homework_lesson8.task2;

public class Client2 {
    private String name;
    private int summ;

    public Client2(String name, int summ) {
        this.name = name;
        this.summ = summ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }
    @Override
    public String toString() {
        return name + " " + summ ;
    }
}
