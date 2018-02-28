package lection9;


import java.util.Date;
import java.util.Scanner;

/**
 * Created by Ivan Isaev on 28.02.2018.
 */
public class Except {
    public static void main(String[] args) {
        //classCast();
        //nullPoint();
        //numberFormat();
        //arrayIndex();
    }

    public static void classCast(){
        Object test = new Date();
        Integer date = (Integer) test;
    }

    public static void nullPoint(){
        Integer test = null;
        int[] a = new int[test];
    }

    public static void numberFormat(){
        String a = "fff";
        int f = Integer.parseInt(a);
    }

    public static void arrayIndex(){
        int a [] = {1, 2, 3};
        a[3] = 4;
    }
}
