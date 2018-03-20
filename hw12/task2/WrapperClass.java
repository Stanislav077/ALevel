package lection13;

import lection13.position.Position;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Ivan Isaev on 18.03.2018.
 */
public class WrapperClass implements Iterable<Position> {
    public List<Position> listPosition;
    public int size;

    WrapperClass(List<Position> listPosition){
        this.listPosition = listPosition;
        this.size = listPosition.size();
    }

    @Override
    public Iterator<Position> iterator() {
        return new Iterator<Position>() {
            public int index = 0;
            @Override
            public boolean hasNext() {
                if(listPosition.get(index) != null && index < size){
                    return true;
                }
                return false;
            }

            @Override
            public Position next() {
                if (listPosition.get(index).getPrice() < 5){
                    index++;
                    return listPosition.get(index);
                }
                return listPosition.get(index);
            }
        };
    }
}
