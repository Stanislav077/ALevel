package wrapper;

public class Demo {
    public static void main(String[] args) {
        String name = "Ivan";
        StringMethod stringMethod = new StringMethod(name);
        stringMethod.concat("111");
        System.out.println(stringMethod.toString());
        stringMethod.toUpperCase("aaa");
        System.out.println(stringMethod.toString());
    }
}
