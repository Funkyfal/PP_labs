import java.io.File;

public class Main {
    public static void main(String[] args) {
        Client[] database = new Client[5];
        for(int i = 0 ; i < 5; i++)
            database[i] = new Client(
                    new Credit_Card("1234567890123456", "HOLDER_NAME", "CVV", 0, 0),
                    new Account("ID", 0), "Client_Name");
        try {
            Connector con = new Connector(new File("Data_base.dat"));
            con.write(database);
            Client[] database1 = con.read();
            System.out.println("The clients: ");
            for (Client n : database1) {
                System.out.println(n);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}