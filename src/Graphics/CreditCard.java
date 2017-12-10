package Graphics;

/**
 * Created by Bianca on 2/11/2017.
 */
public class CreditCard {
    private String ID;
    private String owner;
    private double balance;

    public double getBalance(){return balance;}
    public void setBalance(double newBalance){balance = newBalance;}

    public boolean hasEnoughBalance(double ammount){
        if (balance < ammount)
            return false;
        return true;
    }
}
