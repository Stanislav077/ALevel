package com.shop.shelf;

import com.shop.position.impl.Pen;
import com.shop.position.impl.abst.AbstractPosition;

/**
 * Created by Ivan Isaev on 25.02.2018.
 */
public class PenShelf implements Shelf {
    public static int PenShelf_SIZE = 5;

    public static Pen[] penShelf = new Pen[PenShelf_SIZE];

    public PenShelf(Pen[] pen){
        this.penShelf = pen;
    }

    public int currIndex = PenShelf_SIZE;

    @Override
    public int getCurrIndex() {
        return currIndex;
    }

    @Override
    public boolean put(AbstractPosition position){
        if (currIndex >= penShelf.length) {
            return false;
        } else {
            penShelf[currIndex++] = (Pen) position;
            return true;
        }
    }

    public AbstractPosition get(){
        if(currIndex == 0){
            return null;
        }
        return penShelf[--currIndex] = null;
    }

    public boolean checkAvailable(){
        return currIndex > 0;
    }
}