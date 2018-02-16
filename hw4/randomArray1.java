package lection4.hw4;

import java.util.Random;

/**
 * Created by Ivan Isaev on 12.02.2018.
 */
public class randomArray1 {
    public static void main(String[] args) {
        randomArray();
    }

    public static void randomArray(){
        Random random = new Random();
        int[][] array = new int[8][5];
        for (int i =0; i < 8; i++){
            for (int j = 0; j < 5; j++){
                int ran = 10 + random.nextInt(90);
                array[i][j] = ran;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
