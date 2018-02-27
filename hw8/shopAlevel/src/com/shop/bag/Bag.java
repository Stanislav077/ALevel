package com.shop.bag;

import com.shop.position.Position;

/**
 * Created by Ivan Isaev on 21.02.2018.
 */
public interface Bag {
    int getNotUsedSize();

    void add(Position position);

    Position[] getPositions();

    void setRealIndex(int realIndex);

    boolean haveNext();

    Position next();

    void initIterator();

    void sort();

    void setPositions(Position[] positions);
}
