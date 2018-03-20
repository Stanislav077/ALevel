package lection13;

import lection13.position.Position;
import lection13.position.impl.Apple;
import lection13.position.impl.Pen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan Isaev on 18.03.2018.
 */
public class Main {
    public static Random rn = new Random();
    public static List<Position> listPosition = new ArrayList<>();
    public static void main(String[] args) {
        init();
        for (Position li : listPosition){
            System.out.println(li.getName() + ":" +li.getPrice());
        }
        System.out.println("-------------------");
        WrapperClass wrapperClass = new WrapperClass(listPosition);
        for (Position list : wrapperClass){
            System.out.println(list.getName() + ":" + list.getPrice());
        }
    }

    public static void init(){
        for (int i = 0; i < 20; i ++){
            listPosition.add(new Apple(rn.nextInt(8) + 1, "yablochko"));
            listPosition.add(new Pen(3, "ruchka"));
        }
    }


}
