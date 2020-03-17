public class A0459RepeatedSubstringPattern {

//    用kmp更快，但是我仍然没能完全理解如何构造kmp数组
//    这个解法不是经典kmp，是kmp的灵活应用，还是没看懂，暂时放弃kmp
    public boolean repeatedSubstringPattern(String str) {
        int i = 1, j = 0, n = str.length();
        int[] dp = new int[n+1];
        while (i < n) {
            if (str.charAt(i) == str.charAt(j)) dp[++i] = ++j;
            else if (j == 0) ++i;
            else j = dp[j];
        }
        return dp[n] !=0 && (dp[n] % (n - dp[n]) == 0);
    }

    public boolean repeatedSubstringPattern2(String s) {
        char[] c = s.toCharArray();
        for (int k = 1; k < s.length(); k++) {
            if (c[k] == c[0] && s.length() % k == 0) {
                for (int i = k; i < s.length(); i++) {
                    if (c[i % k] != c[i]) {
                        break;
                    }
                    if (i == s.length() - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new A0459RepeatedSubstringPattern().repeatedSubstringPattern("abaababaab"));
        System.out.println(new A0459RepeatedSubstringPattern().repeatedSubstringPattern("abcab"));
        System.out.println(new A0459RepeatedSubstringPattern().repeatedSubstringPattern("abcabc"));
        System.out.println(new A0459RepeatedSubstringPattern().repeatedSubstringPattern("aaaa"));
        System.out.println(new A0459RepeatedSubstringPattern().repeatedSubstringPattern("ababa"));
        System.out.println(new A0459RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
    }
}
