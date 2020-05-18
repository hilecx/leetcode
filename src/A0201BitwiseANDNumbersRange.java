import java.util.BitSet;

public class A0201BitwiseANDNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int sum=0;
        boolean flag=false;
        int x;
        boolean m1;
        boolean n1;
        for (int i = 31; i >=0 ; i--) {
            x=0;
            if(!flag) {
                m1 = isOne(m,i);
                n1 = isOne(n,i);
                if(m1^n1) {//不一样
                    flag=true;
                }else {
                    x=m1?1:0;
                }
            }
            sum+=x<<i;
        }
        return sum;
    }

    public static boolean isOne(int number,int bit){
        int n = 1<<bit;
        return (n&number)>0;
    }

    public static void main(String[] args) {
//        Integer i = new Integer(8);
        System.out.println(new A0201BitwiseANDNumbersRange().rangeBitwiseAnd(5,7));
        System.out.println(new A0201BitwiseANDNumbersRange().rangeBitwiseAnd(234555,245566));
        System.out.println(true^true);
        System.out.println(true^false);
        System.out.println(false^false);
//        System.out.println(isOne(6,2));
//        System.out.println(isOne(6,3));
//        System.out.println(((1<<2))&6);
//        System.out.println(4&7);
//        System.out.println(4&5);
//        System.out.println(2&5);
//        System.out.println(Math.pow(2,31)-1);
//        System.out.println(Math.pow(2,31)-1);
//        System.out.println(Integer.valueOf("1100",2));
//        System.out.println(5&6&7&8);

    }
}
