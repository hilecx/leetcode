import java.util.Arrays;

//经典的LCP问题，解法多样
public class A0014LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        char[] prefix = strs[0].toCharArray();
        int maxPrefixIndex = prefix.length;

        for (int i = 1; i < strs.length; i++) {
            int j=0;
            char[] strloop = strs[i].toCharArray();
            for (; j < maxPrefixIndex && j<strloop.length; j++) {
                if(prefix[j]==strloop[j]){
                    continue;
                }else{
                    break;
                }
            }
            maxPrefixIndex = j;
        }
        return String.valueOf(prefix,0,maxPrefixIndex);
    }

    public String longestCommonPrefix9(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        if(strs[0].length()==0){
            return "";
        }
//        CharSequence charSequence1 = null;
//        CharSequence charSequence2 = null;
        String r = "";
        for (int i = 0; i < strs[0].length() && i<strs[strs.length-1].length(); i++) {
            if(strs[0].substring(0,i+1).equals(strs[strs.length-1].substring(0,i+1))){
                r = strs[0].substring(0,i+1);
            }else {
                break;
            }
        }
        return r;
//        for (int i = 0; i < strs[0].length() || i<strs[strs.length-1].length(); i++) {
//            charSequence1 = strs[0].subSequence(0,i+1);
//            charSequence2 = strs[strs.length-1].subSequence(0,i+1);
//            if (!charSequence1.toString().equals(charSequence2.toString())){
//                break;
//            }
//        }
//        if(charSequence1.length()==1 && !charSequence1.toString().equals(charSequence2.toString())){
//            return "";
//        }else {
//            return charSequence1.subSequence(0, charSequence1.length() - 1).toString();
//        }
    }

    public static void main(String[] args) {


        System.out.println(new A0014LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(new A0014LongestCommonPrefix().longestCommonPrefix(new String[]{"aa","a"}));
        System.out.println(new A0014LongestCommonPrefix().longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(new A0014LongestCommonPrefix().longestCommonPrefix(new String[]{"","racecar","car"}));
        System.out.println(new A0014LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow",""}));
        System.out.println(new A0014LongestCommonPrefix().longestCommonPrefix(new String[]{""}));
    }
}
