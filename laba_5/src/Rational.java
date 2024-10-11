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

public class Rational {
    private int numerator;
    private int denominator;
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
        this.numerator *= obj2.denominator;
        this.denominator *= obj2.numerator;
    }
    @Override
    public String toString()
    {
        int nod = NOD.findNOD(this.getNumerator(), this.getDenominator());
        this.setNumerator(this.getNumerator() / nod);
        this.setDenominator(this.getDenominator() / nod);
        if(this.denominator != 1)
            return Integer.toString(this.getNumerator()) + '/' + Integer.toString(this.getDenominator());
        else
            return Integer.toString(this.getNumerator());
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
