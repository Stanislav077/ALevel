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


    /*
       ошибка ClassCastException принадлежит к RuntimeException, если данная ошибка возникает лучше обработать блоком
       try/catch
     */
    public static void classCast(){
        Object test = new Date();
        Integer date = (Integer) test;
    }
    /*
       ошибка NullPointerException принадлежит к RuntimeException, тоже лучше не пытаться словить данное исключение и
       обработать блоком try/catch, а if сделать проверку на null
     */
    public static void nullPoint(){
        Integer test = null;
        int[] a = new int[test];
    }
    /*
       ошибка NumberFormatException принадлежит к RuntimeException тоже лучше не пытаться словить данное исключение, но
       если есть предположение, что данное исключение все таки нало обработать блоком try/catch
     */
    public static void numberFormat(){
        String a = "fff";
        int f = Integer.parseInt(a);
    }
    /*
        ошибка ArrayIndexOutOfBoundsException принадлежит к RuntimeException, лучше обработать if, чтобы не выйти за
        предел массива
     */
    public static void arrayIndex(){
        int a [] = {1, 2, 3};
        a[3] = 4;
    }
}
