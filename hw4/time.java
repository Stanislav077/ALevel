package lection4.hw4;

/**
 * Created by Ivan Isaev on 12.02.2018.
 */
public class time {
    public static void main(String[] args) {
        time();
    }

    public static void time() {
        int sum = 0;
        String form = "%02d";
        StringBuilder in1 = new StringBuilder();
        StringBuilder in2 = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            in1.append(String.format(form, i));
            for (int j = 0; j < 60; j++) {
                in2.append(String.format(form, j)).reverse();
                if (in1.toString().equals(in2.toString())) {
                    sum++;
                }
                in2.delete(0, in2.length());
            }
            in1.delete(0, in1.length());
        }
        System.out.println(sum);
    }
}

