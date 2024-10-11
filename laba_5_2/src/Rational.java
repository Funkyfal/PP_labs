import java.util.Iterator;

class NOD
{
    public static int findNOD(int a, int b)
    {
        if (b == 0) {
            return a;
        }
        return findNOD(b, a % b);
    }
}

public class Rational implements Comparable<Rational>, Iterable<Integer>{
    private int numerator;
    private int denominator;
    private boolean compByNumenator = false;
    private boolean compByDenominator = false;
    private boolean compByEverything = true;

    public void compareByNumenator()
    {
        compByDenominator = false;
        compByEverything = false;
        compByNumenator = true;
    }
    public void compareByDenominator()
    {
        compByDenominator = true;
        compByEverything = false;
        compByNumenator = false;
    }
    public void compareByEverything()
    {
        compByDenominator = false;
        compByEverything = true;
        compByNumenator = false;
    }
    public Rational(){
        setNumerator(1);
        setDenominator(1);
    }
    public Rational(int a, int b){
        if(b == 0)
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        setNumerator(a);
        setDenominator(b);
    }
    public Rational(String str) {
        if (str.contains("/"))
        {
            String[] parts = str.split("/");
            if (parts.length == 2)
            {
                int num = Integer.parseInt(parts[0]);
                int denom = Integer.parseInt(parts[1]);
                if (denom != 0)
                {
                    this.numerator = num;
                    this.denominator = denom;
                    return;
                }
                else
                {
                    throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
                }
            }
        }
        else
        {
            int num = Integer.parseInt(str);
            this.numerator = num;
            this.denominator = 1;
        }
    }
    public void add(Rational obj2)
    {
        this.setNumerator((this.getNumerator() * obj2.getDenominator()) + (obj2.getNumerator() * this.getDenominator()));
        this.setDenominator(this.getDenominator() * obj2.getDenominator());
    }
    public void sub(Rational obj2)
    {
        this.setNumerator((this.getNumerator() * obj2.getDenominator()) - (obj2.getNumerator() * this.getDenominator()));
        this.setDenominator(this.getDenominator() * obj2.getDenominator());
    }
    public void multiply(Rational obj2)
    {
        this.numerator *= obj2.numerator;
        this.denominator *= obj2.denominator;
    }
    public void divide(Rational obj2)
    {
        if(obj2.numerator == 0)
            throw new IllegalArgumentException("Делить на ноль нельзя");
        this.numerator *= obj2.denominator;
        this.denominator *= obj2.numerator;
    }

    @Override
    public String toString()
    {
        if(this.numerator != 0)
        {
            int nod = NOD.findNOD(this.getNumerator(), this.getDenominator());
            this.setNumerator(this.getNumerator() / nod);
            this.setDenominator(this.getDenominator() / nod);
        }
        if(this.denominator != 1)
            return Integer.toString(this.getNumerator()) + '/' + Integer.toString(this.getDenominator());
        else
            return Integer.toString(this.getNumerator());
    }

    @Override
    public int compareTo(Rational obj)
    {
        double first = (double) this.getNumerator() / this.getDenominator();
        double second = (double) obj.getNumerator() / obj.getDenominator();
        if(this.compByNumenator)
            return Integer.compare(this.numerator, obj.numerator);
        else if(this.compByDenominator)
            return Integer.compare(this.denominator, obj.denominator);
        else
            return Double.compare(first, second);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RationalIterator();
    }
    private class RationalIterator implements Iterator<Integer> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < 2;
        }
        @Override
        public Integer next() {
            if (index == 0) {
                index++;
                return numerator;
            } else if (index == 1) {
                index++;
                return denominator;
            } else {
                throw new IllegalStateException("Итератор завершил итерацию");
            }
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if(denominator == 0)
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        this.denominator = denominator;
    }
}