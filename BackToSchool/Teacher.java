/**
 * Created by Ivan Isaev on 23.02.2018.
 */
public class Teacher extends Person {
    private double salary;
    private String subject;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    Teacher(String name, int age, String gender, String subject, double salary){
        super(name, age, gender);
        this.subject = subject;
        this.salary = salary;
    }
    @Override
    public String toString(){
        return super.toString() + ", subject: " + subject + ", salary: " + salary;
    }
}
