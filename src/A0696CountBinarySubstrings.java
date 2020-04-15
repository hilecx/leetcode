import java.util.Stack;

public class A0696CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int c0=0;
        boolean preIs1=false;
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            if(chars[i]=='0'){
                if(preIs1){
                    c0=1;
                    preIs1=false;
                }else {
                    c0++;
                }
            }else {
                if(c0>0){
                    c0--;
                    count++;
                    preIs1=true;
                }
            }
        }
        System.out.println(count);
        c0=0;
        preIs1=false;
        for (int i = s.length()-1; i >=0; i--) {
            if(chars[i]=='0'){
                if(preIs1){
                    c0=1;
                    preIs1=false;
                }else {
                    c0++;
                }
            }else {
                if(c0>0){
                    c0--;
                    count++;
                    preIs1=true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new A0696CountBinarySubstrings().countBinarySubstrings("1110000100"));
//        System.out.println(new A0696CountBinarySubstrings().countBinarySubstrings("0011110100"));
//        System.out.println(new A0696CountBinarySubstrings().countBinarySubstrings("0101"));
//        System.out.println(new A0696CountBinarySubstrings().countBinarySubstrings("00110011"));
//        System.out.println(new A0696CountBinarySubstrings().countBinarySubstrings("10101"));
    }

}
