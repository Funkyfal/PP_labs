import java.io.Serializable;

public class Account implements Serializable {
    private static final long SerialVersionUID = 2L;
    private String AccountID;
    private double Balance;

    public Account() {
        AccountID = "";
        Balance = 0;
    }

    public Account(String AccountId, double Balance) {
        this.AccountID = AccountId;
        this.Balance = Balance;
    }

    public void addBalance(double add) {
        Balance += add;
    }

    public void subBalance(double sub) {
        if(Balance - sub < 0)
            throw new IllegalArgumentException("Баланс счета не может быть меньше нуля");
        Balance -= sub;
    }

    public void anulBalance()
    {
        this.Balance = 0;
    }
    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        if(balance < 0)
            throw new IllegalArgumentException("Баланс счета не может быть меньше нуля");
        Balance = balance;
    }
}
