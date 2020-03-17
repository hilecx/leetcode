import java.util.HashSet;
import java.util.Set;

public class A0202HappyNumber {
//    Based on our exploration so far, we'd expect continually following links to end in one of three ways.
//
//    It eventually gets to 11.
//    It eventually gets stuck in a cycle.
//    It keeps going higher and higher, up towards infinity.
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int r = getNumber(n);
        while (r!=1 && !set.contains(r)){
            set.add(r);
            r = getNumber(r);
            System.out.println(r);
        }
        return r==1;
    }

    private int getNumber(int n) {
        int r = 0;
        int m = 0;
        while (n > 0) {
            m = n % 10;
            n = n / 10;
            r += m * m;
        }
        return r;
    }


    public static void main(String[] args) {
        System.out.println(new A0202HappyNumber().isHappy(0));
    }
}
