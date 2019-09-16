package homework_lesson8.task1;

public class Client implements Comparable<Client> {
    private String name;
    private String summ;

    public Client(String name, String summ) {
        this.name = name;
        this.summ = summ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSumm() {
        return summ;
    }

    public void setSumm(String summ) {
        this.summ = summ;
    }

    @Override
    public int compareTo(Client o) {
        return summ.compareTo(o.getSumm());
    }

    @Override
    public String toString() {
        return name + " " + summ ;
    }
}

