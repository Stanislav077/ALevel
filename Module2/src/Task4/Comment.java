package Task4;

/**
 * Created by Ivan Isaev on 13.04.2018.
 */
public class Comment {
    String userId;
    String comment;

    Comment(String userId, String comment){
        this.userId = userId;
        this.comment = comment;
    }

    public String toString(){
        return userId + " : " + comment;
    }
}
