package adapter;

import builder.Person;
import com.google.gson.Gson;

public class AdapterPerson {

    public static String toJSON(Person personBuilder){
        Gson gson = new Gson();
        return gson.toJson(personBuilder);
    }

    public static Person getPerson(String jsonPerson){
        Gson gson = new Gson();
        return gson.fromJson(jsonPerson, Person.class);
    }
}
