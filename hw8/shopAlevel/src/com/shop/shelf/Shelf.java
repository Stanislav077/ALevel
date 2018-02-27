package com.shop.shelf;

import com.shop.position.impl.abst.AbstractPosition;

/**
 * Created by Ivan Isaev on 25.02.2018.
 */
public interface Shelf {

    boolean put(AbstractPosition position);

    AbstractPosition get();

    int getCurrIndex();

    boolean checkAvailable();
}
