package model.services;

import java.util.Date;

public class PhoneCommunication implements Service {
    private String phoneNumber;
    private String provider;
    private String accountNum;
    private double sum;
    private String type;
    private Date date;
    private String operationsId;

    public PhoneCommunication() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

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

    @Override
    public String toString() {
        return "PhoneCommunication{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", provider='" + provider + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", sum=" + sum +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", operationsId='" + operationsId + '\'' +
                '}';
    }
}
