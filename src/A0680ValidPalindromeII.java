public class A0680ValidPalindromeII {

//    wrong answer
    public boolean validPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        boolean isdeleted = false;
        while (i <= j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
                continue;
            } else if (chars[i + 1] == chars[j] && !isdeleted) {
                i++;
                isdeleted = true;
                continue;
            } else if (chars[i] == chars[j - 1] && !isdeleted) {
                j--;
                isdeleted = true;
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (chars[i] != chars[j]) {
                return isPalindrome(chars, i + 1, j) || isPalindrome(chars, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(char[] chars, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (chars[k] != chars[j - k + i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A0680ValidPalindromeII().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(new A0680ValidPalindromeII().validPalindrome("abba"));
        System.out.println(new A0680ValidPalindromeII().validPalindrome("abca"));
        System.out.println(new A0680ValidPalindromeII().validPalindrome("aba"));
        System.out.println(new A0680ValidPalindromeII().validPalindrome("abada"));
        System.out.println(new A0680ValidPalindromeII().validPalindrome("abba"));
    }
}
