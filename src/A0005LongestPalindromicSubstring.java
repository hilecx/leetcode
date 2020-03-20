public class A0005LongestPalindromicSubstring {
    //错误答案
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        if (isPalindromic(chars, i, j)) {
            return String.valueOf(chars, i, j + 1);
        }
        while (i <= j) {
            if (isPalindromic(chars, i + 1, j)) {
                return String.valueOf(chars, i, j - i + 1);
            }
            if (isPalindromic(chars, i, j - 1)) {
                return String.valueOf(chars, i, j - i + 1);
            }
            i++;
            j--;
        }
        return "";
    }

    private String f(char[] chars, int start, int end) {
        if (isPalindromic(chars, start + 1, end)) {
            return String.valueOf(chars, start, end - start + 1);
        }
        if (isPalindromic(chars, start, end - 1)) {
            return String.valueOf(chars, start, end - start + 1);
        }
        f(chars, start + 1, end);
        f(chars, start, end - 1);
        return "";
    }

    private boolean isPalindromic(char[] chars, int start, int end) {
        if (start == end) {
            return true;
        }
        if (chars[start] == chars[end]) {
            int i = start + 1;
            int j = end - 1;
            while (true) {
                if (i == j || i == j + 1) {
                    return true;
//                    return String.valueOf(chars,start,end-start+1);
                }
                if (chars[i] == chars[j]) {
                    i++;
                    j--;
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(String.valueOf(new char[]{'a','b','c','d','e'},1,2));
//        System.out.println(new A0005LongestPalindromicSubstring().longestPalindrome("ababa"));
        System.out.println(new A0005LongestPalindromicSubstring().longestPalindrome("ababd"));
    }
}
