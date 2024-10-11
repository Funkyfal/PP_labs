import java.io.Serializable;
public class Credit_Card implements Serializable {

    private static final long SerialVersionUID = 1L;
    private String CVV;
    private String Number;
    private String HolderName;

    private double CreditDebt;
    private boolean is_Banned;

    private double Balance;

    public Credit_Card()
    {
        CVV = "";
        Number = "";
        HolderName = "";
        is_Banned = false;
        Balance = 0;
        CreditDebt = 0;
    }
    public Credit_Card(String Number, String HolderName, String CVV, double Balance, double CreditDebt)
    {
        this.CVV = CVV;
        this.Number = Number;
        this.HolderName = HolderName;
        this.is_Banned = false;
        this.Balance = Balance;
        this.CreditDebt = CreditDebt;
    }
    public void sub(double amount) {
        if (Balance - amount < 0) {
            double temp = amount - Balance;
            Balance = 0;
            CreditDebt -= temp;
            if (CreditDebt < -200)
                this.setIs_Banned(true);
        }
    }
    public String getHolderName() {
        return HolderName;
    }

    public void setHolderName(String holderName) {
        HolderName = holderName;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public boolean isIs_Banned() {
        return is_Banned;
    }

    public void setIs_Banned(boolean is_Banned) {
        this.is_Banned = is_Banned;
    }

    public double getCreditDebt() {
        return CreditDebt;
    }

    public void setCreditDebt(double creditDebt) {
        CreditDebt = creditDebt;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
