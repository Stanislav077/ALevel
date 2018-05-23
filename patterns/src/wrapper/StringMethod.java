package wrapper;

public class StringMethod extends StringWrapper {

    private String string;

    public StringMethod(String string) {
        super(string);
    }

    public String concat(String string){
        string = this.string + string;
        return string;
    }

    public String toUpperCase(String string){
        string = string.toUpperCase();
        return string;
    }
}
