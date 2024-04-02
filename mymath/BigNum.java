package mymath;

import java.math.BigInteger;
import java.util.Arrays;

public class BigNum
{
	public static final 
	
	private final BigInteger integer;
	private final double fraction;

	// this is the most efficient 2-parameter constructor
	/** Constructs a BigNum with integer part integer
	 * and fractional part fraction.
	 * Keep in mind fractional part  is always added.
	 */
	public BigNum(BigInteger integer, double fraction)
	{
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
	public BigNum(long integer, double fraction)
	{
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

	public String toString()
	{
		if (this.integer.compareTo(BigInteger.ZERO) == -1)
			return this.integer.add(BigInteger.ONE).toString() + String.valueOf(1.0 - fraction).substring(1);

		return this.integer.toString() + String.valueOf(this.fraction).substring(1);
	}
}
