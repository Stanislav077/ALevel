package hw13.task1;

import java.util.HashMap;

/**
 * Created by Ivan Isaev on 23.03.2018.
 */
public class Horse implements Runnable {
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();
    private int distance;
    private int sleeping;
    private int currentDistance;
    private int numberHorse;
    private String name;
    private static int horseWinnerPosition = 0;

    public static HashMap<Integer, Integer> getHashMap() {
        return hashMap;
    }

    public int getCurrentDistance() {
        return currentDistance;
    }

    public String getName() {
        return name;
    }

    public int getNumberHorse() {
        return numberHorse;
    }

    Horse(String name, int numberHorse){
        this.name = name;
        this.numberHorse = numberHorse;
    }

    public int getSleeping() {
        return sleeping;
    }

    private static final int MAX_DISTANCE = 1000;

    @Override
    public void run() {
        do {
            try {
                runIpodrom();
                Thread.sleep(getSleeping());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (checkRun());
        ++horseWinnerPosition;
        System.out.println("Horse: " + getName() + getNumberHorse() + " run on position: " + horseWinnerPosition);
        if(horseWinnerPosition == 1){
            hashMap.put(horseWinnerPosition, getNumberHorse());
        }
    }

    public void runIpodrom(){
        distance = (int) (Math.random() * 21) + 30;
        sleeping = (int) (Math.random() * 101) + 300;
        currentDistance += distance;
    }

    public boolean checkRun(){
        return getCurrentDistance() < MAX_DISTANCE;
    }
}