public class A0796RotateString {

    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
//    有点乱，最终还是对了
    public boolean rotateString2(String A, String B) {
//        if(A==null||A.length()==0||B==null||B.length()==0){
//            return;
//        }
        if(A.length()!=B.length()){
            return false;
        }
        char[] ca = A.toCharArray();
        char[] cb = B.toCharArray();
        int ia = 0;
        int ib = 0;
        while (ia != ca.length) {
            while (ca[ia] != cb[0]) {
                if (++ia == ca.length)
                    return false;
            }

            int tmpia = ia;
            ib=0;
            while (ca[tmpia] == cb[ib]) {
                ib++;
                if (ib == cb.length) {
                    return true;
                }
                tmpia++;
                if (tmpia == ca.length) {
                    tmpia = 0;
                }
            }
            ia++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A0796RotateString().rotateString("bbbacddceeb", "ceebbbbacdd"));
        System.out.println(new A0796RotateString().rotateString("aa", "a"));
        System.out.println(new A0796RotateString().rotateString("abcde", "deabc"));
        System.out.println(new A0796RotateString().rotateString("abcde", "daabc"));
        System.out.println(new A0796RotateString().rotateString("ba", "ab"));
        System.out.println(new A0796RotateString().rotateString("ab", "ab"));
    }
}
