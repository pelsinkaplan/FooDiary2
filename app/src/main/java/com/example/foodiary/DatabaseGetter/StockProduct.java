package com.example.foodiary.DatabaseGetter;

public class StockProduct {
    private String name;
    private int skt;
    private String amount;
    public StockProduct(String name,int skt,String amount){
        this.name = name;
        this.skt = skt;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkt() {
        return skt;
    }

    public void setSkt(int skt) {
        this.skt = skt;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
