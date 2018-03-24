package hw13.task1;

/**
 * Created by Ivan Isaev on 23.03.2018.
 */
public class Player {
    private static int countPlayer = 0;
    private String name;
    private int bet;
    private int better = 0;

    public int getBetter() {
        return better;
    }

    public String getName() {
        return name;
    }

    Player(int better){
        this.better = better;
        this.bet = (int) (Math.random() *90) + 10;
        this.name = "Player-" + (++countPlayer) + ": bet on horse: " + better + " - money: " + bet;
    }
}
