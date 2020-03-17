public class A0029DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend >= 0 && divisor > 0)  {
            while (dividend > divisor) {
                dividend -= divisor;
            }
        }else if(dividend < 0 && divisor < 0){
            while (dividend < divisor) {
                divisor -= dividend;
            }
        }


        return 1;
    }
}
