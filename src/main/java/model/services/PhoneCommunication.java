package model.services;

import java.util.Date;

public class PhoneCommunication implements Service {
    private int id;
    private String phoneNumber;
    private String provider;
    private double sum;
    private String type;
    private Date date;

    public PhoneCommunication() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "PhoneCommunication{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", provider='" + provider + '\'' +
                ", sum=" + sum +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
