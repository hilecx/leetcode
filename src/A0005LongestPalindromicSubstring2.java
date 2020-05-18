public class A0005LongestPalindromicSubstring2 {
    //错误答案
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        return null;
    }


    public static void main(String[] args) {
//        System.out.println(String.valueOf(new char[]{'a','b','c','d','e'},1,2));
//        System.out.println(new A0005LongestPalindromicSubstring().longestPalindrome("ababa"));
        System.out.println(new A0005LongestPalindromicSubstring2().longestPalindrome("ababd"));
    }
}
