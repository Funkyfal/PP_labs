import java.util.*;
import java.io.*;

public class Main {

    public static Client[] createDataBase() {
        Client[] base = new Client[5];

        base[0] = new Client(AppLocale.getString(AppLocale.client));
        base[0].setClient_Name("Oliver_Fisher");
        base[0].setAcc(new Account("0", 0));
        base[0].setCard(new Credit_Card("12345678901234567", "OLIVER_FISHER", "386", 50, 0));

        base[1] = new Client(AppLocale.getString(AppLocale.client));
        base[1].setClient_Name("Emma_Johnson");
        base[1].setAcc(new Account("1", 100));
        base[1].setCard(new Credit_Card("23456789012345678", "EMMA_JOHNSON", "124", 150, 0));

        base[2] = new Client(AppLocale.getString(AppLocale.client));
        base[2].setClient_Name("James_Smith");
        base[2].setAcc(new Account("2", 300));
        base[2].setCard(new Credit_Card("34567890123456789", "JAMES_SMITH", "432", 30, 0));

        base[3] = new Client(AppLocale.getString(AppLocale.client));
        base[3].setClient_Name("Ava_Williams");
        base[3].setAcc(new Account("3", 200));
        base[3].setCard(new Credit_Card("45678901234567890", "AVA_WILLIAMS", "324", 0, -20));

        base[4] = new Client(AppLocale.getString(AppLocale.client));
        base[4].setClient_Name("Noah_Jones");
        base[4].setAcc(new Account("4", 600));
        base[4].setCard(new Credit_Card("56789012345678901", "NOAH_JONES", "754", 570, 0));

        return base;
    }

    static Locale createLocale(String[] args) {
        if (args.length == 2) {
            return new Locale(args[0], args[1]);
        } else if (args.length == 4) {
            return new Locale(args[2], args[3]);
        }
        return null;
    }

    static void setupConsole(String[] args) {
        if (args.length >= 2) {
            if (args[0].equals("-encoding")) {
                try {
                    System.setOut(new PrintStream(System.out, true, args[1]));
                } catch (UnsupportedEncodingException ex) {
                    System.err.println("Unsupported encoding: " + args[1]);
                    System.exit(1);
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            setupConsole(args);
            Locale loc = createLocale(args);
            if (loc == null) {
                System.err.println("Invalid argument(s)\n"
                        + "Syntax: [-encoding ENCODING_ID] language country\n"
                        + "Example: -encoding Cp855 be BY");
                System.exit(1);
            }
            AppLocale.set(loc);
            Connector con = new Connector(new File("base_stage2.dat"));
            con.write(createDataBase());
            Client[] base = con.read();
            System.out.println(AppLocale.getString(AppLocale.data_base) + ":");
            for (Client n : base) {
                System.out.println(n);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
