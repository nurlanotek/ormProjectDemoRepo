package org.uca.sas.cs.course1.lesson5.model;

public class TacoOrder {
    private int orderId;
    private String tacoName;
    private double tacoPrice;
    private Integer count;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTacoName() {
        return tacoName;
    }

    public void setTacoName(String tacoName) {
        this.tacoName = tacoName;
    }

    public double getTacoPrice() {
        return tacoPrice;
    }

    public void setTacoPrice(double tacoPrice) {
        this.tacoPrice = tacoPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
