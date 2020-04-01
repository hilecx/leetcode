public class A1071GreatestCommonDivisorofStrings {
    public String gcdOfStrings(String str1, String str2) {
        int i = 0;
        int j = 0;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        boolean end1 = false;
        boolean end2 = false;
        while (!end2 || !end1) {
            if (chars1[i] != chars2[j]) {
                return "";
            }
            if (i == chars1.length - 1) {
                i = 0;
                end1 = true;
            } else {
                i++;
            }
            if (j == chars2.length - 1) {
                j = 0;
                end2 = true;
            } else {
                j++;
            }
        }
        int mcd = maxCommonDivisor(str1.length(), str2.length());
        return String.valueOf(chars1, 0, mcd);
    }

    public static int maxCommonDivisor(int m, int n) {
        if (m < n) {     // 保证被除数大于除数
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {  // 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;    // 返回最大公约数
    }

    public static void main(String[] args) {
        System.out.println(new A1071GreatestCommonDivisorofStrings().gcdOfStrings("abcabc", "abc"));
    }
}
