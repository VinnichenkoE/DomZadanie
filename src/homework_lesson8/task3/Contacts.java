package homework_lesson8.task3;

public class Contacts {
    private String name;
    private String telepnonNumber;
    private String email;

    public Contacts(String name,String telepnonNumber,String email){
        this.name = name;
        this.telepnonNumber = telepnonNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelepnonNumber() {
        return telepnonNumber;
    }

    public void setTelepnonNumber(String telepnonNumber) {
        this.telepnonNumber = telepnonNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + " " +  telepnonNumber+ " " + email;
    }
}
