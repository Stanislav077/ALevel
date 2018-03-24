package hw13.task1;

import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 23.03.2018.
 */
public class Hipodrom {
    static ArrayList<Player> playerArrayList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("THIS IS AMAZING HIPPODROM!!!\n" +
                            "____________________________");
        ArrayList<Horse> horseArrayList = new ArrayList<>();
        ArrayList<Thread> threadArrayList = new ArrayList<>();
        for(int i =0; i < 5; i++){
            horseArrayList.add(new Horse("Burushka-", (i+1)));
            threadArrayList.add(new Thread(horseArrayList.get(i)));
            playerArrayList.add(new Player((int) (Math.random() * (5-1)) + 1));
            System.out.println(playerArrayList.get(i).getName());
        }
        for (Thread thread : threadArrayList){
            thread.start();
        }
        try {
            for(int i = 0; i < threadArrayList.size(); i++){
                threadArrayList.get(i).join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("____________________________________\n" +
                           "---------------RESULTS--------------");
        checkWinner();
    }

    public static void checkWinner(){
        for(int i = 0; i < playerArrayList.size(); i++){
            if(playerArrayList.get(i).getBetter() == Horse.getHashMap().get(1)){
                System.out.println("Winner: " + playerArrayList.get(i).getName());
            }
        }
    }
}
