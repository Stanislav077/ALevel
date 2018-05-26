package adapter;

import builder.Person;

public class Demo {
    public static void main(String[] args) {
        AdapterPerson adapterPerson = new AdapterPerson();
        Person person = Person.newBuilder().setCity("Kharkiv").setStreetAddress("Otakara Yarosha").build();
        String json = adapterPerson.toJSON(person);
        System.out.println(json);
    }
}
