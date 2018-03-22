package Task1;

/**
 * Created by Ivan Isaev on 13.03.2018.
 */
public class Teacher {
    String firstName;
    String lastName;

    Teacher(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
