package lection6.hw6.CompanyEmployees;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class LPR extends CompanyEmployees {
    LPR(String name, String position){
        super(name, position);
    }

    public void LPR(){
        System.out.println("Name: " + name + ", position: " + position);
    }
}
