package cfeb2021;

public class Number1Bits {
    public int hammingWeight(int n) {
        boolean positive = true;
        if(n<0){
            n = - n - 1;
            positive = false;
        }
        int c = 0;
        int m = 0;
        while (n>0){
            m = n%2;
            c+=m;
            n=n/2;
        }
        return positive?c:32-c;
    }


    public static void main(String[] args) {
        System.out.println(new Number1Bits().hammingWeight(-2));
    }
}
