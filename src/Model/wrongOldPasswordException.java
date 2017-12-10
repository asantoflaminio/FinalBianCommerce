package Model;

/**
 * Created by Bianca on 2/11/2017.
 */
public class wrongOldPasswordException extends Exception {

    public wrongOldPasswordException(){
        System.out.println("Wrong Old Password, please try again");
    }
}
