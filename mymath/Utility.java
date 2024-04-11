package mymath;

import java.math.BigInteger;

public class Utility 
{
    // can be made more precise and efficient
    /** Takes a BigInteger and a double and returns the
     * a BigInteger realtively close to the expected 
     * mathematical result of the integer times the double.
     * (ex. partial(101, 0.25) -> 25)
     * inexact
     */
    public static BigInteger partial(BigInteger integer, double part) throws IllegalArgumentException
    {
        if (part > 1.0 || part < -1.0) throw new IllegalArgumentException(
            "Double parameter must be between [-1.0, 1.0]"
        );

        // 10 to the 17th
        long n = 100000000000000000L;

        int power = 0;
        while (part < 0.00000000000000001) 
        {
            power++;
            part = Math.sqrt(part);
        }

        for (int i = 0; i < Math.pow(2, power); i++) 
        {
            integer = integer.multiply(BigInteger.valueOf((long)(part * n))).divide(BigInteger.valueOf(n));
        }

        return integer;
    }
}