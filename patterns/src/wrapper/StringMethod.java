package wrapper;

public class StringMethod {

    String string;

    StringMethod(String string){
        this.string = string;
    }

    public void concat(String string){
        this.string = this.string + string;
    }

    public void toUpperCase(String string){
        this.string = string.toUpperCase();
    }

    public String toString(){
        return this.string;
    }
}
