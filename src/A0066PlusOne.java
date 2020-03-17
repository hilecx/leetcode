import java.util.Arrays;

public class A0066PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] != 9){
                digits[i]+=1;
                return digits;
            }else if (digits[i] == 9 && i!=0){
                digits[i]=0;
                continue;
            }else {
                int[] d = new int[digits.length+1];
                d[0]=1;
//                System.arraycopy(d,1,digits,0,digits.length);  //这行不需要，默认值是0
                return d;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new A0066PlusOne().plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(new A0066PlusOne().plusOne(new int[]{4, 3, 2, 9})));
        System.out.println(Arrays.toString(new A0066PlusOne().plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(new A0066PlusOne().plusOne(new int[]{9})));
        System.out.println(Arrays.toString(new A0066PlusOne().plusOne(new int[]{0})));
    }
}
