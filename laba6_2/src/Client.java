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

    public Client(String name) {
        setClient_Name(name);
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
        return "---------------\n"
                + getClient_Name() + " - " + AppLocale.getString(AppLocale.client_name) + "\n"
                + Card.getNumber() + " - " + AppLocale.getString(AppLocale.card_number) + "\n"
                + Card.getCVV() + " - " + AppLocale.getString(AppLocale.CVV) + "\n"
                + Card.getBalance() + " - " + AppLocale.getString(AppLocale.card_balance) + "\n"
                + Card.getCreditDebt() + " - " + AppLocale.getString(AppLocale.card_debt) + "\n"
                + Acc.getAccountID() + " - " + AppLocale.getString(AppLocale.account_ID) + "\n"
                + Acc.getBalance() + " - " + AppLocale.getString(AppLocale.account_balance) + "\n"
                + "---------------\n";
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
