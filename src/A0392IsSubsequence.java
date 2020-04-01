public class A0392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int j=0;
        for (int i = 0; i < ct.length; i++) {
            if(ct[i]==cs[j]){
                j++;
            }
            if(j==cs.length){
                return true;
            }
        }

        return false;
    }
//slower than first method
    public boolean isSubsequence2(String s, String t) {
        if (s.length() > t.length())
            return false;

        if(s.length()==0){
            return true;
        }
        int j=0;
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i)==s.charAt(j)){
                j++;
            }
            if(j==s.length()){
                return true;
            }
        }

        return false;
    }
}
