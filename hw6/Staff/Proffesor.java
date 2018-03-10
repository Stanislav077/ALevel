package lection6.hw6.Staff;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Proffesor extends Teacher {
    Proffesor() {

    }

    Proffesor(String university) {
        super(university);
    }

    public String lookProfil(String perfomance) {
        perfomance = "Perfomance: " + perfomance;
        return perfomance;
    }

    public void lookProfile() {
        System.out.println(university);
    }
}
