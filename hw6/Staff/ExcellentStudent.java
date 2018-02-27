package lection6.hw6.Staff;

import java.util.Arrays;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class ExcellentStudent extends Student {
    static String name;
    static int[] mark;

    ExcellentStudent(String name) {
        this.name = name;
    }

    ExcellentStudent(String name, int[] mark) {
        this.name = name;
        this.mark = mark;
    }

    public String lookProfi() {
        String profile = "Name: " + name;
        return profile;
    }

    public void lookProfile() {
        System.out.println("Name: " + name);
        System.out.println("Mark: " + Arrays.toString(mark));

    }
}
