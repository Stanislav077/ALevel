package lection6.hw6.CompanyEmployees;

/**
 * Created by Ivan Isaev on 27.02.2018.
 */
public class JavaDev extends Developer {
    JavaDev(String name, String position, String language){
        super(name, position, language);
    }

    @Override
    public void lookProfile() {
        super.lookProfile();
        System.out.println(language);
    }
}
