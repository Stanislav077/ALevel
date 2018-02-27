package lection4.hw4;

import java.util.Arrays;

/**
 * Created by Ivan Isaev on 13.02.2018.
 */
public class sort {
    public static void main(String[] args) {
        sort(array);
    }

    public static int[] array = {5, 3, 1, 2};

    public static void sort(int[] array) {
        int temp;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Number of permutations = " + count);
    }
}

