package hw12.Animal;

import java.io.Serializable;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Animal implements Serializable {
    static boolean eat;
    static int walkSpeed;

    Animal() {

    }

    Animal(boolean eat, int walkSpeed) {
        this.eat = eat;
        this.walkSpeed = walkSpeed;
    }

    public void see(boolean see) {
        if (see == true) {
            System.out.println("See");
        } else {
            System.out.println("No see");
        }
    }

    public void lookProfile() {
        if (eat == true) {
            System.out.println("This animal can eat and speed " + walkSpeed);
        } else {
            System.out.println("Soon die");
        }
    }
}
