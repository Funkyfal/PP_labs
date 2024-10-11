import java.io.*;
import java.util.*;

public class Bank_Account implements Serializable{
    private static final long serialVersionUID = 1L;
    String accNMB;
    static final String P_accNMB = "Account NMB";
    String owner;
    static final String P_owner = "Owner";
    String accCode;
    static final String P_accCode = "Account Code";
    String date;
    static final String P_year = "Year";
    String currency;
    static final String P_currency = "Currency";
    String annual_rate;
    static final String P_annual_rate = "Annual Rate";
    double balance;
    static final String P_balance = "Balance";

    static Boolean validAccNMB(String str) {
        if(str.length() != 10)
            return false;
        int k = 0;
        for(int i = 0 ; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(Character.isDigit(ch) || Character.isLetter(ch))
                k++;
        }
        return k == 10;
    }

    private static GregorianCalendar curCalendar = new GregorianCalendar();

    static Boolean validYear(String str) {
        if (str == null || str.length() != 10) {
            return false;
        }
        try {
            String[] parts = str.split("\\.");
            if (parts.length != 3) {
                return false;
            }
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            curCalendar.setLenient(false);
            curCalendar.set(year, month - 1, day);
            curCalendar.getTime();
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    public static boolean nextRead(Scanner fin, PrintStream out) {
        return nextRead(P_accNMB, fin, out);
    }

    static boolean nextRead(final String prompt, Scanner fin, PrintStream out) {
        out.print(prompt);
        out.print(": ");
        return fin.hasNextLine();
    }

    public static final String authorDel = ",";

    public static Bank_Account read(Scanner fin, PrintStream out) throws IOException,
            NumberFormatException {
        String str;
        Bank_Account acc = new Bank_Account();
        acc.accNMB = fin.nextLine().trim();
        if (!Bank_Account.validAccNMB(acc.accNMB)) {
            throw new IOException("Invalid Account Number: " + acc.accNMB);
        }
        if (!nextRead(P_owner, fin, out)) {
            return null;
        }
        acc.owner = fin.nextLine();
        if (!nextRead(P_accCode, fin, out)) {
            return null;
        }
        acc.accCode = fin.nextLine();
        if (!nextRead(P_currency, fin, out)) {
            return null;
        }
        acc.date = fin.nextLine();
        if (!Bank_Account.validYear(acc.date)) {
            throw new IOException("Invalid Book.year value");
        }
        if (!nextRead(P_currency, fin, out)) {
            return null;
        }
        acc.currency = fin.nextLine();
        if (!nextRead(P_annual_rate, fin, out)) {
            return null;
        }
        acc.annual_rate = fin.nextLine();
        if (!nextRead(P_balance, fin, out)) {
            return null;
        }
        str = fin.nextLine();
        acc.balance = Double.parseDouble(str);
        return acc;
    }

    public Bank_Account() {
    }

    public static final String areaDel = "\n";

    public String toString() {
        return accNMB + areaDel +
                owner + areaDel +
                accCode + areaDel +
                date + areaDel +
                currency + areaDel +
                annual_rate + areaDel +
                balance;
    }
}