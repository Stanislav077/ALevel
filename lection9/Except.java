package lection9;


import java.util.Date;
import java.util.Scanner;

/**
 * Created by Ivan Isaev on 28.02.2018.
 */
public class Except {
    public static void main(String[] args) {
        classCast();
        nullPoint();
        numberFormat();
        arrayIndex();
    }
    /*
       ошибка ClassCastException принадлежит к RuntimeException, если данная ошибка возникает лучше обработать блоком
       try/catch
     */
    public static void classCast(){
        Object test = new Date();
        if (test instanceof Integer){
            Integer date = (Integer) test;
        } else{
            System.out.println("ClassCastException");
        }
    }
    /*
       ошибка NullPointerException принадлежит к RuntimeException, тоже лучше не обработать блоком try/catch,
       а if сделать проверку на null
     */
    public static void nullPoint(){
        Integer test = null;
        if(test != null){
            int[] a = new int[test];
        } else {
            System.out.println("NullPointerException");
        }
    }
    /*
       ошибка NumberFormatException принадлежит к RuntimeException тоже лучше не пытаться словить данное исключение,
       лучше сделать проверку, подобную такую, как в данном случае
     */
    public static void numberFormat(){
        String a = "fff";
        if (a.getClass().equals(Integer.class)){
            int f = Integer.parseInt(a);
        } else {
            System.out.println("NumberFormatException");
        }
    }
    /*
        ошибка ArrayIndexOutOfBoundsException принадлежит к RuntimeException, лучше обработать if, чтобы не выйти за
        предел массива
     */
    public static void arrayIndex(){
        int a [] = {1, 2, 3};
        int index = 3;
        if (index < a.length)
        {
            a[index] = 4;
        } else {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
    }
}
