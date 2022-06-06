package model;

import java.util.Date;

public class Credit {
    private String name;
    private int id;
    private double sum;
    private int term;
    private double percent;
    private double monthlyPayment;
    private Date dateOfIssue;
    private Date lastPayment;
    private double totalPayed;
    private double remainsToPay;
    private int userId;

    public Credit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(Date lastPayment) {
        this.lastPayment = lastPayment;
    }

    public double getTotalPayed() {
        return totalPayed;
    }

    public void setTotalPayed(double totalPayed) {
        this.totalPayed = totalPayed;
    }

    public double getRemainsToPay() {
        return remainsToPay;
    }

    public void setRemainsToPay(double remainsToPay) {
        this.remainsToPay = remainsToPay;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
