package hw13.task2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Сделал Executors по примеру данного сайта http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
//Хороший гайд по Executors там и впринципе все туториалы

/**
 * Created by Ivan Isaev on 25.03.2018.
 */
public class Main {
    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Search a prime number in interval: 1 - 10000\n" +
                "please, enter a start number:>> ");
        int start = in.nextInt();
        System.out.print("please last number:>> ");
        int finish = in.nextInt();
        System.out.print("Please enter a count Threads:>> ");
        int countThreads = in.nextInt();
        primeNumber(start, finish, countThreads);
    }

    public static void primeNumber(int start, int finish, int countThreads){
        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);
        executorService.submit(() -> {
            System.out.println("Runnable at work=)");
            int length = finish - start + 1;
            int[] array = new int[length];
            int temp = start;
            for (int i = 0; i < length; i++) {
                array[i] = temp;
                temp++;
                if (array[i] == 1) {
                    array[i] = 0;
                }
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    continue;
                }
                for (int j = 2; j < array[i]; j++) {
                    if (array[i] != j && array[i] % j == 0) {
                        array[i] = 0;
                        break;
                    }
                }
            }
            for (Integer ar : array) {
                if (ar != 0) {
                    arrayList.add(ar);
                }
            }
        });
        try {
            executorService.shutdown();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!executorService.isTerminated()) {
                System.out.println("Bad");
            }
            executorService.shutdownNow();
            System.out.println("Shutdown finished");
        }
        for (Integer ar : arrayList) {
            System.out.print(ar + " ");
        }
    }
}