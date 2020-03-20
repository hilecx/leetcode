public class A0758BoldWordsinString {
    //没做，暴力解法，应该可以用kmp优化
    public String boldWords(String[] words, String S) {
        boolean[] mark = new boolean[S.length()];
        char[] chars = S.toCharArray();
        for (int i = 0; i < words.length; i++) {
            char[] p = words[i].toCharArray();
            int pi=0;
            int si=0;
            while (true){

            }
        }
        return "";
    }
}
