import java.util.Arrays;

public class A0168ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        char[] r =new char[7];
        int i = 6;
        int x = 0;
        while(n>0){
            x = (n-1)%26;
            r[i--] = (char)(x+65);
            n=(n-1)/26;
        }
        System.out.println(Arrays.toString(r));
        return new String(r).trim();
    }

    public static void main(String[] args) {
        System.out.println(new A0168ExcelSheetColumnTitle().convertToTitle(27));
    }
}
