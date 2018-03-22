package Task1;

import java.util.ArrayList;

/**
 * Created by Ivan Isaev on 13.03.2018.
 */
public class Rating {
    ArrayList<Integer> mark = new ArrayList<Integer>();

    public ArrayList<Integer> getMark() {
        return mark;
    }

    public void avgRatingPass(){
        int sum = 0;
        for(int i = 0; i < mark.size(); i++){
            sum += mark.get(i);
        }
        double avgRating = sum/mark.size();
        if (avgRating >= 3){
            System.out.println("Congratulations. You are welcome in the University ALevel");
        } else{
            System.out.println("Try yet in the next year");
        }
    }
}
