package lection5.hw5;

import java.util.Arrays;

/**
 * Created by Ivan Isaev on 16.02.2018.
 */
public class QuickSort {
    public static void main(String[] args) {
        System.out.println(quickSortArray());
    }
    private static String quickSortArray(){
        int[] arr = {3, 0, 1, 8, 7, 2, 5, 4, 9, 6};
        int first = 0;
        int last = arr.length-1;
        quickSortArrayLocal(arr, first, last);
        return Arrays.toString(arr);
    }

    public static void quickSortArrayLocal(int[] arr, int first, int last){
        int temp;
        int mid = arr[first + (last-first)/2];
        int i = first;
        int j = last;
        while (i <= j) {
            while (arr[i]<mid){
                i++;
            }
            while (arr[j]>mid) {
                j--;
            }
            if(i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if(first < j){
            quickSortArrayLocal(arr, first, j);
        }
        if (last > i){
            quickSortArrayLocal(arr, i, last);
        }
    }
}