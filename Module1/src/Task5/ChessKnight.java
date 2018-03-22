package Task5;

/**
 * Created by Ivan Isaev on 15.03.2018.
 */
public class ChessKnight {
    private int xPosition;
    private char yPosition;

    ChessKnight(int xPosition, char yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public char getyPosition() {
        return yPosition;
    }
}
