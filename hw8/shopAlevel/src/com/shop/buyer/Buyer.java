package com.shop.buyer;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public interface Buyer {

    boolean orderPay(double sum);

    Order getOrderStatus();

    String lookProfileBueyer();

}
