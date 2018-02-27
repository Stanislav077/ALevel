package lection6.hw6.Staff;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Student extends Staff {
    Student() {

    }

    Student(String university) {
        super(university);
    }

    @Override
    public void choiseUnivercity() {
        super.choiseUnivercity();
    }

    public String lookProfile(String perfomance) {
        perfomance = "Perfomance: " + perfomance;
        return perfomance;
    }
}
