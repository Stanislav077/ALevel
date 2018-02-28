package lection6.hw6.CompanyEmployees;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class CompanyEmployees {
    static String name;
    static String position;

    CompanyEmployees(){

    }

    CompanyEmployees(String name, String position){
        this.name = name;
        this.position = position;
    }

    public String lookProfil(){
        String profile = "Name: " + name + ", position: " + position;
        return profile;
    }
}
