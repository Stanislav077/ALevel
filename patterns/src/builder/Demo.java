package builder;

public class Demo {
    public static void main(String[] args) {
        Person person = Person.newBuilder().setCity("Kharkiv").setStreetAddress("Otakara Yarosha").build();
        System.out.println(person.getCity() + " " + person.getStreetAddress() + " " + person.getLastName());
    }
}
