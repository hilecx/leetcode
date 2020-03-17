public class A0069Sqrtx {
//    二分法：注意溢出问题
    public int mySqrt1(int x) {

        if (x == 0) {
            return 0;
        }
        if (x > 0 && x <= 3) {
            return 1;
        }
        if (x == 4) {
            return 2;
        }

        Long min = 0l;
        Long max = Long.valueOf(x);

        while (max - min >= 2) {
            Long c = min + (max - min) / 2;
            if (c * c > x) {//这里int相乘会变long
                max = c;
            } else if (c * c < x) {
                min = c;
            } else {
                return c.intValue();
            }
        }
        return min.intValue();
    }


//    牛顿法：利用切线a=x; f(x)=x*x-a可以很有效地求出根号 aa 的近似值：首先随便猜一个近似值 xx，然后不断令 xx 等于 xx 和 a/xa/x 的平均数，迭代个六七次后 xx 的值就已经相当精确了。
//

    int s;

    public int mySqrt(int x) {
        s=x;
        if(x==0) return 0;
        return ((int)(sqrts(x)));
    }

    public double sqrts(double x){
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }


    public static void main(String[] args) {

        System.out.println(new A0069Sqrtx().mySqrt(2147395599));
        System.out.println(new A0069Sqrtx().mySqrt(8));
        System.out.println(new A0069Sqrtx().mySqrt(7));
        System.out.println(new A0069Sqrtx().mySqrt(0));
        System.out.println(new A0069Sqrtx().mySqrt(1));
        System.out.println(new A0069Sqrtx().mySqrt(2));
        System.out.println(new A0069Sqrtx().mySqrt(3));
        System.out.println(new A0069Sqrtx().mySqrt(4));
        System.out.println(new A0069Sqrtx().mySqrt(5));
        System.out.println(new A0069Sqrtx().mySqrt(6));
        System.out.println(new A0069Sqrtx().mySqrt(9));
    }
}
