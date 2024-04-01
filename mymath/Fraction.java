package mymath;

public class Fraction
{
	public static final Fraction ZERO = new Fraction(0, 1);
	public static final Fraction ONE = new Fraction(1, 1);
	
	private final int numer;
	private final int denom;

	private static int gcd(int p, int q)
	{
		if (q == 0) return p;
		return gcd(q, p % q);
	}

	public Fraction simplify()
	{
		int numer = this.numer / gcd(this.denom, this.numer);
		int denom = this.denom / gcd(this.denom, this.numer);
		if (denom < 0)
		{
			numer *= -1;
			denom *= -1;
		}
		return new Fraction(numer, denom);
	}

	public Fraction(int numer, int denom)
	{
		this.numer = numer;
		this.denom = denom;
	}

	public Fraction add(Fraction other)
	{
		int numer = this.numer * other.denom + other.numer * this.denom;
		int denom = this.denom * other.denom;
		return (new Fraction(numer, denom)).simplify();
	}

	public Fraction subtract(Fraction other)
	{
		int numer = this.numer * other.denom - other.numer * this.denom;
		int denom = this.denom * other.denom;
		return (new Fraction(numer, denom)).simplify();
	}

	public Fraction multiply(Fraction other)
	{
		int numer = this.numer * other.numer;
		int denom = this.denom * other.denom;
		return (new Fraction(numer, denom)).simplify();
	}

	public Fraction divide(Fraction other)
	{
		int numer = this.numer * other.denom;
		int denom = this.denom * other.numer;
		return (new Fraction(numer, denom)).simplify();
	}

	public Fraction neg()
	{
		return new Fraction(this.numer * -1, this.denom);
	}

	public Fraction recip()
	{
		return (new Fraction(this.denom, this.numer)).simplify();
	}

	public String toString()
	{
		return String.format("%d/%d", numer, denom);
	}
}
