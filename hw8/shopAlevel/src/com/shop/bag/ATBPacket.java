package com.shop.bag;

import com.shop.position.Position;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ivan Isaev on 21.02.2018.
 */
public class ATBPacket implements Bag {
    private static final int SIZE = 100000;

    private Position[] positions = new Position[SIZE];

    private int realIndex = 0;

    @Override
    public Position[] getPositions() {
        return positions;
    }

    @Override
    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    private int iteratorIndex = 0;

    public void setRealIndex(int realIndex) {
        this.realIndex = realIndex;
    }

    @Override
    public int getNotUsedSize() {
        return SIZE - realIndex;
    }

    public void add(Position position){
        positions[realIndex++] = position;
    }

    public boolean haveNext(){
        return  iteratorIndex < realIndex;
    }

    public Position next(){
        return positions[iteratorIndex++];
    }

    public void initIterator(){
        iteratorIndex = 0;
    }

    public void sort(){
        Arrays.sort(positions, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
    }
}
