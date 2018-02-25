/**
 * Created by Ivan Isaev on 23.02.2018.
 */
public class Student extends Person {
    private String idNumber;
    private double gpa;


    Student(String name, int age, String gender, String idNumber, double gpa) {
        super(name, age, gender);
        this.idNumber = idNumber;
        this.gpa = gpa;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String toString() {
        return super.toString() + ", student id: " + getIdNumber() + ", gpa: " + getGpa();
    }
}
