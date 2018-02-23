/**
 * Created by Ivan Isaev on 23.02.2018.
 */
public class Person {
    private String name;
    private int age;
    private String gender;

    Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString(){
        return name + ", age: " + age + ", gender: " + gender;
    }

    public static void main(String[] args) {
        Person[] person = new Person[6];
        person[0] = new Person("Vasya Pupkin", 21, "M");
        person[1] = new Teacher("Mcconaughey", 48, "M", "Criminalogy", 9999.99);
        person[2] = new Student("William  Blazkowicz", 35, "M", "007f", 007);
        person[3] = new Student("Dean Winchester", 33, "M", "555b", 111);
        person[4] = new CollegeStudent("Bary Allen", 24, "M", "88a", 19, 1994, "Running");
        person[5] = new CollegeStudent("Tony Stark", 45, "M", "89D", 25, 1963, "Ingineering");
        for (Person persons : person) {
            System.out.println(persons.toString());
        }
    }
}
