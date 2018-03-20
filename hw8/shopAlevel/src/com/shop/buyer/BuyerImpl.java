package com.shop.buyer;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class BuyerImpl implements Buyer {

    private String nameBuyer;
    private double money;

    public BuyerImpl(String nameBuyer, double money){
        this.nameBuyer = nameBuyer;
        this.money = money;
    }

    private Order orderStatus = Order.OPEN;

    public boolean orderPay(double sum){
        if(sum > money){
            return  false;
        } else{
            orderStatus = Order.PAID;
            money -=sum;
            return true;
        }
    }

    public Order getOrderStatus(){
        return orderStatus;
    }

    public String lookProfileBueyer(){
        return "Name: " +nameBuyer + ", money: " + money + ". OrderStatus: " + getOrderStatus();
    }
}
