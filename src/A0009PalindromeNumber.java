public class A0009PalindromeNumber {


    public boolean isPalindrome2(int x) {
        int r = 0;

        if (x >= 0 && x <= 9) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        while (x > 0) {//倒转数字
            try {
                r = r * 10 + x % 10;
                x = x / 10;
                if (x == r || r == (x / 10)) {
                    return true;
                }
            } catch (ArithmeticException e) {
                return false;
            }

        }
        return false;

    }

    public boolean isPalindrome(int x) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A0009PalindromeNumber().isPalindrome(1234321));
        System.out.println(new A0009PalindromeNumber().isPalindrome(12134321));
        System.out.println(new A0009PalindromeNumber().isPalindrome(-1234321));
        System.out.println(new A0009PalindromeNumber().isPalindrome(0));
        System.out.println(new A0009PalindromeNumber().isPalindrome(10));
    }
}
