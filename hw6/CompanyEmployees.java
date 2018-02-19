package lection6.hw6;

/**
 * Created by Ivan Isaev on 20.02.2018.
 */

class Main2 {
    public static void main(String[] args) {
        CompanyEmployees companyEmployees = new CompanyEmployees("Sergey", "Developer");
        System.out.println(companyEmployees.lookProfil());
        Developer developer = new Developer();
        Developer developer1 = new Developer("Andrey", "QA");
        System.out.println(developer.lookProfil());
        developer1.lookProfile();
        JavaDev javaDev = new JavaDev("Ivan", "dev", "java");
        javaDev.lookProfile();
        LPR lpr = new LPR("Vitya", "Project Manager");
        lpr.LPR();
        CTO cto = new CTO("Artem", "Android dev");
        cto.LPR();
    }
}

public class CompanyEmployees {

    String name;
    String position;

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

class Developer extends CompanyEmployees{

    String language;

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

class JavaDev extends Developer {

    JavaDev(String name, String position, String language){
        super(name, position, language);
    }

    @Override
    public void lookProfile() {
        super.lookProfile();
        System.out.println(language);
    }
}

class LPR extends CompanyEmployees{

    LPR(String name, String position){
        super(name, position);
    }

    public void LPR(){
        System.out.println("Name: " + name + ", position: " + position);
    }
}

class CTO extends LPR{
    CTO(String name, String position){
        super(name, position);
    }

    public void LPR(){
        System.out.println("Position: " + position + ", name: " + name);
        System.out.println("Override");
    }
}