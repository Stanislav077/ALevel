package lection6.hw6.Staff;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Staff {
    static boolean talk;
    static String university;
    static String duties;

    Staff() {

    }

    Staff(String university) {
        this.university = university;
    }

    Staff(boolean talk, String duties) {
        this.talk = talk;
        this.duties = duties;
    }

    public void staff() {
        System.out.println("Hello world");
    }

    public void lookProfile() {
        if (talk == true) {
            System.out.println("This staff can talk, and duties " + duties);
        } else {
            System.out.println("Duties " + duties);
        }
    }

    public void choiseUnivercity() {
        System.out.println(university);
    }
}
