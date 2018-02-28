package lection6.hw6.CompanyEmployees;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class Main2 {
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
