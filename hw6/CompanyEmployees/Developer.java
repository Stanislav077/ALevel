package lection6.hw6.CompanyEmployees;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Developer extends CompanyEmployees {
    static String language;

    Developer(){
        language = "Swift";
    }

    Developer(String name, String position){
        super(name, position);
    }

    Developer(String name, String position, String language){
        super(name, position);
        this.language = language;
    }

    public String lookProfil(){
        return language;
    }

    public void lookProfile(){
        System.out.println("Name: " + name + ", position: " + position);
    }
}
