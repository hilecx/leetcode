public class A0205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] w1 = new int[128];
        int[] w2 = new int[128];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int charsi =chars[i]+1;
            int charti =chart[i]+1;
            if(w1[charsi]==0){
                w1[charsi] = charti;
            }else if(w1[charsi]!=charti){
                return false;
            }
            if(w2[charti]==0){
                w2[charti] = charsi;
            }else if(w2[charti]!=charsi){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new A0205IsomorphicStrings().isIsomorphic("abcdd","dfgrr"));//true
        System.out.println(new A0205IsomorphicStrings().isIsomorphic("abcdd","dfgrq"));//f
        System.out.println(new A0205IsomorphicStrings().isIsomorphic("abcd","abcc"));//f
        System.out.println(new A0205IsomorphicStrings().isIsomorphic("abcqd","jkend"));//t
    }


}
