package lection4.hw4;

import java.util.Random;

/**
 * Created by Ivan Isaev on 12.02.2018.
 */
public class randomArray2 {
    public static void main(String[] args) {
        randomArray();
    }

    public static void randomArray() {
        Random random = new Random();
        int[][] array = new int[7][4];
        int[] tempArray = new int[array.length];
        int max = 0;
        int index = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                int ran = -5 + random.nextInt(10);
                array[i][j] = ran;
                System.out.print(array[i][j] + " ");
                if (j == 0) {
                    tempArray[i] = array[i][j];
                } else {
                    tempArray[i] *= array[i][j];
                }
                for (int k = 0; k < tempArray.length; k++) {
                    if (Math.abs(tempArray[k]) > max) {
                        max = tempArray[k];
                        index = k;
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\nRow index = " + index);
    }
}
