import java.util.Date;

/**
 * Created by Ivan Isaev on 31.03.2018.
 */
public class Employees {
    String first_name;
    String last_name;
    Date hire_date;
    int salary;

    Employees(String first_name, String last_name, Date hire_date){
        this.first_name = first_name;
        this.last_name = last_name;
        this.hire_date = hire_date;
    }

    Employees(String first_name, String last_name, int salary){
        this.first_name = first_name;
        this.last_name = last_name;
        this.salary = salary;
    }

    Employees(String first_name){
        this.first_name = first_name;
    }

}
