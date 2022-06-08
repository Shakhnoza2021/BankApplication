package model.services;

import java.util.Date;

public class Fine implements Service {

    private double sum;
    private String docNumber;
    private String company;
    private String accountNum;
    private String type;
    private Date date;
    private String operationsId;

    public Fine() {
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperationsId() {
        return operationsId;
    }

    public void setOperationsId(String operationsId) {
        this.operationsId = operationsId;
    }
}
