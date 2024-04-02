import mymath.BigNum;

class Test
{
    public static void main(String[] args)
    {
        BigNum a = BigNum.ZERO;
        for (int i = 0; i < 1000; i++)
        {
            a = a.add(BigNum.ONE);
        }
        System.out.println(a);
    }
}