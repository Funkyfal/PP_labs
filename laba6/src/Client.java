import java.io.Serializable;

public class Client implements Serializable {
    private final static long SerialVersionUID = 3L;

    private Credit_Card Card;
    private Account Acc;
    private String Client_Name;

    public Client() {
        this.Card = new Credit_Card();
        this.Acc = new Account();
        this.Client_Name = "";
    }

    public Client(Credit_Card card, Account acc, String Name) {
        this.Card = card;
        this.Acc = acc;
        this.Client_Name = Name;
    }

    public void transferToTheOtherAccount(String TargetAccount, double Amount) {
        if (this.Acc.getBalance() >= Amount)
            this.Acc.setBalance(this.Acc.getBalance() - Amount);
        else
            throw new IllegalArgumentException("Недостаточно средст на счете");
    }

    public void makePayment(Payment pay) {
        Card.sub(pay.cost);
        System.out.println(pay.type + " " + pay.source + " " + Card.getBalance() + " " + Card.getCreditDebt());
    }

    public String toString() {
        return "---------------\n" + Client_Name + "\n" + Card.getNumber() + " - card number\n" + Card.getCVV()
                + " - card CVV\n" + Card.getBalance() + " - card Balance\n" + Card.getCreditDebt() + " - credit debt\n"
                + Acc.getAccountID() + " - account ID\n" + Acc.getBalance() + " - account balance\n" + "---------------\n";
    }

    public void blockCard()
    {
        Card.setIs_Banned(true);
    }

    public void annulCard()
    {
        Card.setBalance(0);
    }

    public Credit_Card getCard() {
        return Card;
    }

    public void setCard(Credit_Card card) {
        Card = card;
    }

    public Account getAcc() {
        return Acc;
    }

    public void setAcc(Account acc) {
        Acc = acc;
    }

    public String getClient_Name() {
        return Client_Name;
    }

    public void setClient_Name(String client_Name) {
        Client_Name = client_Name;
    }
}
