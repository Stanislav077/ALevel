package Task3;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ivan Isaev on 13.03.2018.
 */
public class SetArray {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size array:>>");
        int size = in.nextInt();
        int array[] = new int[size]; //8
        for (int i = 0; i < size; i ++){
            array[i] = ran.nextInt(20) + 1;
            System.out.print(array[i] + " ");
        }
        Set set = new HashSet();
        System.out.println();
        System.out.print("Number of different array elements: ");
        for (int i = 0; i < array.length; i++){
            set.add(array[i]);
        }
        System.out.println(set.size());
    }
}
