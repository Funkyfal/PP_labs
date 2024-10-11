import java.io.Serializable;

enum Payment_Type{entertainment, food, government}
public class Payment implements Serializable {
    private final static long SerialVersionUID = 4L;
    public Payment_Type type;
    public double cost;
    public String source;

    Payment()
    {
        type = Payment_Type.entertainment;
        cost = 100.0;
        source = "Company_Name";
    }

    Payment(Payment_Type type_, double cost_, String source_)
    {
        type = type_;
        cost = cost_;
        source = source_;
    }
}
