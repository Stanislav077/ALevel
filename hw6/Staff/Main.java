package lection6.hw6.Staff;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Main {
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
