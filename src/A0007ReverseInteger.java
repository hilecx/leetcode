public class A0007ReverseInteger {

    public int reverse2(int x) {
        String minus = "";
        if (x < 0) {
            minus = "-";
            x = 0 - x;
        }

        try {
            return Integer.valueOf((minus + new StringBuilder(String.valueOf(x)).reverse()).toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int reverse(int x) {
        int r = 0;

//不要用string
//+-*注意判断int溢出
        while (x != 0) {
            try {
                int m = x % 10;
                int r1 = Math.multiplyExact(r, 10);
                r = Math.addExact(r1, m);
                x = x/10;
            }catch (ArithmeticException e){
                return 0;
            }

        }
        return r;
    }

    public int reverse1(int x) {
        long temp = 0;

        while(x != 0){
            int pop = x % 10;
            temp = temp * 10 + pop;

            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)temp;
    }

    public static void main(String[] args) {
        Math.addExact(Integer.MAX_VALUE-1, 3);
        int b = 1534236469;
        System.out.println(new A0007ReverseInteger().reverse(b));
        int a = -123;
        System.out.println(new A0007ReverseInteger().reverse(a));
        int c = 123;
        System.out.println(new A0007ReverseInteger().reverse(c));
        int d = -1234567;
        System.out.println(new A0007ReverseInteger().reverse(d));
    }
}
