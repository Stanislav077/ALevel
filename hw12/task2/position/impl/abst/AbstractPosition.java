package lection13.position.impl.abst;

import lection13.position.Position;

/**
 * Created by Ivan Isaev on 21.02.2018.
 */
public abstract class AbstractPosition implements Position {

    public double price;

    public String name;

    public AbstractPosition(double price, String name){
        this.price = price;
        this.name = name;
    }

    public AbstractPosition() {

    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Position position){
        String temp = position.getName();
        return this.name.compareTo(temp);
    }
}
