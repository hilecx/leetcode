public class A0171ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int r = 0;
        for (int i = 0; i < c.length; i++) {
            r+=(c[i]-'A'+1)*Math.pow(26,c.length-i-1);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new A0171ExcelSheetColumnNumber().titleToNumber("AB"));
    }
}
