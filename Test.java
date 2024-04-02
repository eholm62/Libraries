import mymath.numbers.BigNum;
import java.math.BigDecimal;

class Test
{
    public static void main(String[] args)
    {
        BigNum a = BigNum.ZERO;
        for (int i = 0; i < 100000000; i++)
        {
            a = a.add(BigNum.ONE);
        }
        System.out.println(a);

        BigDecimal b = new BigDecimal(0.0);
        for (int i = 0; i < 100000000; i++)
        {
            b = b.add(BigDecimal.ONE);
        }
        System.out.println(a);
    }
}