package Task1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ivan Isaev on 13.03.2018.
 */
public class Main {
    static Teacher teacher;
    static Abiturient abitur = new Abiturient("Ivan", "Isaiev");
    static Scanner in = new Scanner(System.in);
    static Rating rat = new Rating();
    public static void main(String[] args) {
        ArrayList<Exam> exam = new ArrayList<>();
        exam.add(Exam.COMPUTER_SCIENCE);
        exam.add(Exam.PHYSICS);
        exam.add(Exam.VYSHMAT);
        int tempCs = 0;
        int tempPhy = 0;
        int tempVysh = 0;
        System.out.println("Hello! University ALevel");
        while(true){
            System.out.println("1: Go to Exam");
            System.out.println("2: To know the rating and whether I entered the university");
            System.out.println("3: Run from the university");
            switch (in.nextInt()){
                case 1: System.out.println("Choose exam: ");
                    for (int i = 0; i < exam.size(); i++){
                        System.out.println((i+1) + ". " + exam.get(i));
                    }
                    switch (in.nextInt()){
                        case 1:
                            if (tempCs == 0) {
                                System.out.println("You choose Computer Science");
                                teacher = new Teacher("Galya", "Antonovna");
                                doExam(exam.get(0));
                                tempCs++;
                                break;
                            } else {
                                System.out.println("You pass this exam");
                            }
                            tempCs++;
                            break;
                        case 2:
                            if (tempPhy == 0){
                                System.out.println("You choose Physics");
                                teacher = new Teacher("Zina", "Sergeevna");
                                doExam(exam.get(1));
                                tempPhy++;
                                break;
                            } else {
                                System.out.println("You pass this exam");
                            }
                            tempPhy++;
                            break;
                        case 3:
                            if (tempVysh == 0){
                                System.out.println("You choose Vyshmat");
                                teacher = new Teacher("L'uda", "Anatol'evna");
                                doExam(exam.get(2));
                                tempVysh++;
                                break;
                            } else {
                                System.out.println("You pass this exam");
                            }
                            tempVysh++;
                            break;
                        default:
                            System.out.println("Choose some exam");
                    }
                    break;
                case 2:
                    if(rat.getMark().size() == 3){
                        rat.avgRatingPass();
                    } else {
                        System.out.println("You did not pass all the exams");
                        System.out.println("Good Luck");
                        break;
                    }
                case 3: System.exit(0);
            }
        }
    }
    public static void doExam(Exam n){
        System.out.println("Hello, teacher. My name " + abitur.getFirstName() + " and surname " + abitur.getLastName());
        System.out.println("Hello. My name " + teacher.getFirstName() + " " + teacher.getLastName());
        System.out.println("And you come to pass " + n + " subject");
        System.out.println("Write exam, you have 1 hour");
        System.out.println("Enter a mark, please: ");
        int mark = in.nextInt();
        rat.getMark().add(mark);
    }
}
