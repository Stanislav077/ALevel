package Task4;

/**
 * Created by Ivan Isaev on 12.04.2018.
 */
public class Photo {
    private String name;
    private String author;

    Photo(String name, String author){
        this.name = name;
        this.author = author;
    }

    public String toString(){
        return name + " " + author;
    }
}
