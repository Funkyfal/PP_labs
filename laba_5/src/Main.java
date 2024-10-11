public class Main {
    public static void main(String[] args) {
        try
        {
            Rational obj = new Rational();
            obj.setDenominator(1);
            obj.setNumerator(2);
            Rational object = new Rational(1,2);
            obj.divide(object);
            System.out.println(obj.toString());
            System.out.println(object.toString());
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}