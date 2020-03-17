import java.math.BigInteger;

public class A0371SumofTwoIntegers {
    public int getSum(int a, int b) {
        BigInteger ba = BigInteger.valueOf(a);
        BigInteger bb = BigInteger.valueOf(b);

        return ba.add(bb).intValue();
    }

    //这题肯定是考位运算，应该这样写
    public int getSum2(int a, int b) {
        return b==0? a:getSum(a^b, (a&b)<<1); //be careful about the terminating condition;

    }
    public static void main(String[] args) {
        Integer i = 3;
        System.out.println(4>>1);
    }
}
