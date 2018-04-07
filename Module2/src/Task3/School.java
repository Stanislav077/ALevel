package Task3;

/**
 * Created by Ivan Isaev on 07.04.2018.
 */
public class School {
    private String classChildren;
    private String count;
    private String fio;

    public School(String classChildren, String count, String fio) {
        this.classChildren = classChildren;
        this.count = count;
        this.fio = fio;
    }

    public String getClassChildren() {
        return classChildren;
    }

    public String getCount() {
        return count;
    }

    public String getFio() {
        return fio;
    }

    public String toString(){
        return  classChildren + " " + count + " " + fio;
    }
}
