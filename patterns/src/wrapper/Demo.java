package wrapper;

public class Demo {
    public static void main(String[] args) {
        String name = "Ivan";
        StringInterface stringInterface = new StringMethod(name);
        stringInterface.toUpperCase(name);
        System.out.println(name);
    }
}
