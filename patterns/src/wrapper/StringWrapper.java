package wrapper;

public abstract class StringWrapper implements StringInterface{

    protected String stringInterface;

    public StringWrapper(String string){
        this.stringInterface = string;
    }

    @Override
    public String concat(String string) {
        return stringInterface.concat(string);
    }

    @Override
    public String toUpperCase(String string) {
        return stringInterface.toUpperCase();
    }
}
