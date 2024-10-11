import java.util.Comparator;
public class RationalComparator implements Comparator<Rational>{
    @Override
    public int compare(Rational obj1, Rational obj2)
    {
        double first = (double) obj1.getNumerator() / obj1.getDenominator();
        double second = (double) obj2.getNumerator() / obj2.getDenominator();
        return Double.compare(first, second);
    }
}
