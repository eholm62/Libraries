package mymath;

import java.math.BigInteger;
import java.util.Arrays;

/** Number type with an arbitrary precision integer part
 * and a double precision float as the fractional part.
 */
public class BigNum // eventually extend Number
{
	public static final BigNum ZERO = new BigNum(BigInteger.ZERO, 0.0);
	public static final BigNum ONE = new BigNum(BigInteger.ONE, 0.0);
	public static final BigNum TWO = new BigNum(BigInteger.TWO, 0.0);
	
	private final BigInteger integer;
	private final double fraction;

	// this is the most efficient 2-parameter constructor
	/** Constructs a BigNum with integer part integer
	 * and fractional part fraction.
	 * Keep in mind fractional part  is always added.
	 */
	public BigNum(BigInteger integer, double fraction) throws IllegalArgumentException
	{
		if (fraction >= 1.0 || fraction <= -1.0)
			throw new IllegalArgumentException("Fractional part must be between (-1.0, 1.0)");

		if (fraction < 0.0)
		{
			this.integer = integer.subtract(BigInteger.ONE);
			this.fraction = 1.0 + fraction;
		}
		else
		{
			this.integer = integer;
		    this.fraction = fraction;
		}
	}

	// this is the most efficient 1-parameter constructor
	/** Constructs a BigNum with integer part integer */
	public BigNum(BigInteger integer)
	{
		this.integer = integer;
		this.fraction = 0.0;
	}

	/** Constructs a BigNum with integer part integer
	 * and fractional part fraction.
	 * Keep in mind fractional part is always added.
	 */
	public BigNum(long integer, double fraction) throws IllegalArgumentException
	{
		if (fraction >= 1.0 || fraction <= -1.0)
			throw new IllegalArgumentException("Fractional part must be between (-1.0, 1.0)");

		if (fraction < 0.0)
		{
			this.integer = BigInteger.valueOf(integer).subtract(BigInteger.ONE);
			this.fraction = 1.0 + fraction;
		}
		else
		{
			this.integer = BigInteger.valueOf(integer);
		    this.fraction = fraction;
		}
	}

	/** Constructs a BigNum with integer part integer */
	public BigNum(long integer)
	{
		this.integer = BigInteger.valueOf(integer);
		this.fraction = 0.0;
	}

	/** Constructs a BigNum with the value of value */
	public BigNum(double value)
	{
		byte[] byteArray = new byte[8];
		long lng = Double.doubleToLongBits(value);
		for (int i = 0; i < 8; i++) 
			byteArray[i] = (byte)((lng >> ((7 - i) * 8)) & 0xff);
		
		this.integer = new BigInteger(byteArray);
		this.fraction = 0.0;
	}	

	/** Takes in a BigInteger for the integer part,
	 * a double for the fractional part, and simplifies
	 * such that the fractional part is positive and less
	 * than 1. It changes the integer part accordingly.
	 * Requires that fractional part is between (-2.0, 2.0).
	 */
	public static BigNum simplify(BigInteger integer, double fraction) throws IllegalArgumentException
	{
		if (fraction <= -2.0 || fraction >= 2.0) throw new IllegalArgumentException(
			"Fractional part must be between (-2.0, 2.0)"
		);
		
		BigInteger newInteger;
		double newFraction;

		if (fraction >= 1.0)
		{
			newInteger = integer.add(BigInteger.ONE);
			newFraction = fraction - 1.0;
		}
		else if (fraction <= -1.0)
		{
			newInteger = integer.subtract(BigInteger.ONE);
			newFraction = fraction + 1.0;
		}
		else 
		{
			if (fraction < 0.0) 
			{
				newInteger = integer.subtract(BigInteger.ONE);
				newFraction = 1.0 + fraction;
			}
			else
			{
				newInteger = integer;
		   	 	newFraction = fraction;
			}
		}

		return new BigNum(newInteger, newFraction);
	}

	public BigNum add(BigNum other)
	{
		return simplify(this.integer.add(other.integer), this.fraction + other.fraction);
	}

	public BigNum subtract(BigNum other)
	{
		return simplify(this.integer.subtract(other.integer), this.fraction - other.fraction);
	}

	public String toString()
	{
		if (this.integer.compareTo(BigInteger.ZERO) == -1)
			return this.integer.add(BigInteger.ONE).toString() + String.valueOf(1.0 - fraction).substring(1);

		return this.integer.toString() + String.valueOf(this.fraction).substring(1);
	}
}
