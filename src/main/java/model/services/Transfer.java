package model.services;

import java.util.Date;

public class Transfer {
    private int id;
    private String cardFrom;
    private String cardTo;
    private Date date;
    private double sum;

    public Transfer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(String cardFrom) {
        this.cardFrom = cardFrom;
    }

    public String getCardTo() {
        return cardTo;
    }

    public void setCardTo(String cardTo) {
        this.cardTo = cardTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
