public class A0125ValidPalindrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (j - i >= 1) {
            while (!isAlphanumeric(s.charAt(i)) && j - i >= 1) {
                i++;
            }
            while (!isAlphanumeric(s.charAt(j)) && j - i >= 1) {
                j--;
            }
            if (!isEqualChar(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    private boolean isEqualChar(char a, char b) {
        if (a == b) {
            return true;
        }

        if (a >= 65 && b >= 65) {
            return Math.abs(a - b) == 32;
        }
        return false;
    }

    private boolean isNumber(char a) {
        return a >= 48 && a <= 57;
    }

    private boolean isChar(char a) {
        return (a >= 65 && a <= 90) || (a >= 97 && a <= 122);
    }

    private boolean isAlphanumeric(char a) {
        return (a >= 48 && a <= 57) || (a >= 65 && a <= 90) || (a >= 97 && a <= 122);
//        return isNumber(a) || isChar(a);
    }
}
