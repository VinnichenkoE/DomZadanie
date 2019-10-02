package graduation_project;

import java.sql.Date;

public class Register {
    private String contractor;
    private double quantity;
    private Date date;

    public Register(String contractor, double quantity, Date date) {
        this.contractor = contractor;
        this.quantity = quantity;
        this.date = date;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Register{" +
                "contractor='" + contractor + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
