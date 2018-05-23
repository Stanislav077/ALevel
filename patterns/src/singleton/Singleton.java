package singleton;

public class Singleton {
    private String name = "Ivan";
    private Singleton(String name){
        this.name = name;
    }
    private static Singleton instance;

    public Singleton getInstance(){
        if(instance == null){
            return new Singleton(name);
        }
        return instance;
    }
}
