package lection5.hw5.Maze;

/**
 * Created by Ivan Isaev on 09.03.2018.
 */

// попробывал реализовать данный алгоритм, вышло так, что он с нижнего угла в верхний угол решается
// для решения данного алгоритма почитал про графы на различных сайтах, не совсем многое понял, но что-то реализовать
// получилось, но с ограниченным функционалом (данный код попытался переделать с С++, но видимо что-то не вышло, т.к.
// решается только с вверха вниз)
public class Maze {
    public static void main(String[] args) {

        Maze labyrinth = new Maze();
        if (labyrinth.findWay(0, 0))
            System.out.println("Good!");
        else
            System.out.println("No solution.");
    }

    int[][] array = {
            {0, 1, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 1, 0}};

    public boolean findWay(int row, int column) {

        boolean done = false;

        if (validWay(row, column)) {

            if (row == array.length - 1 && column == array[0].length - 1)
                done = true;
            else {
                done = findWay(row + 1, column);
                if (!done)
                    done = findWay(row, column + 1);
                if (!done)
                    done = findWay(row - 1, column);
                if (!done)
                    done = findWay(row, column - 1);
            }
            if (done)
                System.out.println(row + "," + column);
        }

        return done;
    }

    private boolean validWay(int row, int column) {

        boolean result = false;

        if (row >= 0 && row < array.length &&
                column >= 0 && column < array[0].length)
            if (array[row][column] == 0)
                result = true;
        return result;
    }
}