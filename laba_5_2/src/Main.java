import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try
        {
            Rational obj = new Rational();
            obj.setDenominator(3);
            obj.setNumerator(1);
            Rational object = new Rational(1,2);
            System.out.println(obj.toString());
            System.out.println(object.toString());
            for (int value : obj)
                System.out.println(value);
            for (int value : object)
                System.out.println(value);

        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

    }
}