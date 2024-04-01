package mymath;

import java.math.BigInteger;

public class BigNum
{
	public static final BigNum ONE = new BigNum(BigInteger.ONE, Fraction.ZERO);
	
	private final BigInteger integer;
	private final Fraction fraction;

	public BigNum(BigInteger integer, Fraction fraction)
	{
		this.integer = integer;
		this.fraction = fraction;
	}

	public String toString()
	{
		return this.integer.toString() + " " + this.fraction.toString();
	}

	public BigNum add(BigNum other)
	{
		BigInteger integer = this.integer.add(other.integer);
		Fraction fraction = this.fraction.add(other.fraction);
		return new BigNum(integer, fraction);
	}

	public BigNum subtract(BigNum other)
	{
		BigInteger integer = this.integer.subtract(other.integer);
		Fraction fraction = this.fraction.subtract(other.fraction);
		return new BigNum(integer, fraction);
	}
}
