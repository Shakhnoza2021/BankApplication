package model.services;

import java.util.Date;

public class CommunalServices implements Service {
    private String name;
    private String company;
    private String personalAcc;
    private String docNumber;
    private String accountNum;
    private double sum;
    private String type;
    private Date date;
    private String operationsId;

    public CommunalServices() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPersonalAcc() {
        return personalAcc;
    }

    public void setPersonalAcc(String personalAcc) {
        this.personalAcc = personalAcc;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    @Override
    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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
