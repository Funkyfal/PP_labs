import java.util.*;

public class AppLocale {
    private static final String strMsg = "Msg";
    private static Locale loc = Locale.getDefault();
    private static ResourceBundle res =
            ResourceBundle.getBundle( AppLocale.strMsg, AppLocale.loc );

    static Locale get() {
        return AppLocale.loc;
    }

    static void set( Locale loc ) {
        AppLocale.loc = loc;
        res = ResourceBundle.getBundle( AppLocale.strMsg, AppLocale.loc );
    }

    static ResourceBundle getBundle() {
        return AppLocale.res;
    }

    static String getString( String key ) {
        return AppLocale.res.getString(key);
    }


    public static final String client = "client";
    public static final String client_name = "client_name";
    public static final String card = "card";

    public static final String account ="account";
    public static final String card_number = "card_number";
    public static final String CVV = "CVV";
    public static final String card_balance="card_balance";
    public static final String card_debt = "card_debt";
    public static final String account_ID = "account_ID";
    public static final String account_balance = "account_balance";
    public static final String data_base="data_base";
}
