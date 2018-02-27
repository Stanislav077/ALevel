package com.shop.shelf;

import com.shop.position.impl.Apple;
import com.shop.position.impl.abst.AbstractPosition;

/**
 * Created by Ivan Isaev on 25.02.2018.
 */
public class AppleShelf implements Shelf {
    public static int AppleShelf_SIZE = 5;

    public static Apple[] appleShelf = new Apple[AppleShelf_SIZE];

    public AppleShelf(Apple[] apple) {
        this.appleShelf = apple;
    }

    public int currIndex = AppleShelf_SIZE;

    public int getCurrIndex() {
        return currIndex;
    }

    @Override
    public boolean put(AbstractPosition position) {
        if (currIndex >= appleShelf.length) {
            return false;
        } else {
            appleShelf[currIndex++] = (Apple) position;
            return true;
        }
    }

    public AbstractPosition get() {
        if (currIndex == 0) {
            return null;
        }
        return appleShelf[--currIndex] = null;
    }

    public boolean checkAvailable(){
        return currIndex > 0;
    }
}