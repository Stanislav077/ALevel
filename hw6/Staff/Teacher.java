package lection6.hw6.Staff;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Teacher extends Staff {
    Teacher() {

    }

    Teacher(String university) {
        super(university);
    }

    Teacher(boolean talk, String duties) {
        super(talk, duties);
    }

    @Override
    public void lookProfile() {
        super.lookProfile();
        System.out.println("this method Override");
    }

    @Override
    public void choiseUnivercity() {
        super.choiseUnivercity();
        System.out.println("this method Override");
    }
}
