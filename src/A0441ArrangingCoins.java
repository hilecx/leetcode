public class A0441ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n <= 1) {
            return n;
        }
        int t = (int) Math.sqrt((double)n * 2);
        System.out.println("t:"+t);
        while (true) {
            int r = gs(t);
            System.out.println("r:"+r+"t:"+t);
            if (r < n) {
                t++;
            } else if (r == n) {
                return t;
            } else {
                return t - 1;
            }
        }
    }

//    public static long gs(long x) {
//        return (1 + x) * x / 2;
//    }
    public static int gs(int x) {
        return (int) ((x+1)*((double)x/2));
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt((double)1804289383*2));
        System.out.println(gs(60071));
//        System.out.println(new A0441ArrangingCoins().arrangeCoins(1));
//        System.out.println(new A0441ArrangingCoins().arrangeCoins(2));
//        System.out.println(new A0441ArrangingCoins().arrangeCoins(3));
        System.out.println(new A0441ArrangingCoins().arrangeCoins(4));
//        System.out.println(new A0441ArrangingCoins().arrangeCoins(5));
//        System.out.println(new A0441ArrangingCoins().arrangeCoins(6));
//        System.out.println(new A0441ArrangingCoins().arrangeCoins(7));
//        System.out.println(new A0441ArrangingCoins().arrangeCoins(1804289383));
//        System.out.println(gs(2));
//        System.out.println(gs(3));
//        System.out.println(gs(4));
//        System.out.println(gs(5));
//        System.out.println(gs(6));
//        System.out.println(gs(7));
    }
}
