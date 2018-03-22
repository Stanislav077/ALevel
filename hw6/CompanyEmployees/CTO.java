package lection6.hw6.CompanyEmployees;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class CTO extends LPR {
    CTO(String name, String position){
        super(name, position);
    }

    public void LPR(){
        System.out.println("Position: " + position + ", name: " + name);
        System.out.println("Override");
    }
}
