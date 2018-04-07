package Task1;

/**
 * Created by Ivan Isaev on 07.04.2018.
 */
public class Demo {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        //проверка этих всех методов
        myList.add(0, 24);
        myList.add(1, 15);
        myList.add(2, 33);
        myList.add(3, 15);
        myList.add(4, 21);
        myList.add(5, 44);
        System.out.println(myList.get(0).toString());
        System.out.println(myList.get(1).toString());
        System.out.println(myList.addElement(0));
        System.out.println(myList.remove(5)); //remove не огонь работает, та и вообще вся реализация без других
        // методов не огонь

    }
}
