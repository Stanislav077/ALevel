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
<<<<<<< HEAD
            public int index = -1;
            @Override
            public boolean hasNext() {
                ++index;
                if(index == size){
                    return false;
                }
                while (listPosition.get(index).getPrice() >= 5 && index < size){
                    index++;
                }
                return (listPosition.get(index).getPrice() < 5 && listPosition.get(index) != null && index < size);
=======
            public int index = 0;
            @Override
            public boolean hasNext() {
                if(listPosition.get(index) != null && index < size){
                    return true;
                }
                return false;
>>>>>>> d599d77e6384c278b17b3c531c2342547fe5b5d7
            }

            @Override
            public Position next() {
<<<<<<< HEAD
=======
                if (listPosition.get(index).getPrice() < 5){
                    index++;
                    return listPosition.get(index);
                }
>>>>>>> d599d77e6384c278b17b3c531c2342547fe5b5d7
                return listPosition.get(index);
            }
        };
    }
}
