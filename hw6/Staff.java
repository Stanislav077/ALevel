package lection6.hw6;

import java.util.Arrays;

/**
 * Created by Ivan Isaev on 19.02.2018.
 */

class Main1 {
    public static void main(String[] args) {
        Staff staff = new Staff();
        Staff staff1 = new Staff("Karazina");
        Staff staff2 = new Staff(true, "security");
        staff.staff();
        staff1.choiseUnivercity();
        staff2.lookProfile();
        System.out.println();
        Teacher teacher = new Teacher(true, "teacher");
        teacher.lookProfile();
        Teacher teacher1 = new Teacher("Yaroslava Mudrogo");
        teacher1.choiseUnivercity();
        Student student = new Student();
        Student student1 = new Student("Kozheduba");
        System.out.println(student.lookProfile("Excellent student"));
        student1.choiseUnivercity();
        System.out.println();
        ExcellentStudent excellentStudent = new ExcellentStudent("Andrey");
        ExcellentStudent excellentStudent1 = new ExcellentStudent("Ivan", new int[]{4, 5, 5, 4, 4});
        System.out.println(excellentStudent.lookProfi());
        excellentStudent1.lookProfile();
        Proffesor proffesor1 = new Proffesor();
        Proffesor proffesor = new Proffesor("Econom university");
        proffesor.lookProfile();
        System.out.println(proffesor1.lookProfil("Best proffesor"));
    }
}

class Staff {

    boolean talk;
    String university;
    String duties;

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

class Teacher extends Staff {

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

class Student extends Staff {

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

class ExcellentStudent extends Student {

    String name;
    int[] mark;

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

class Proffesor extends Teacher {

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