public class A0482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer buffer = new StringBuffer();
        int Kcopy = K;
        char[] chars = S.toCharArray();
        for (int i = chars.length-1; i >=0; i--) {
            if(chars[i]=='-'){
                continue;
            }
            if(Kcopy==K && buffer.length()!=0){
                buffer.append('-');
            }
            buffer.append(Character.toUpperCase(chars[i]));
            if(--Kcopy==0){
                Kcopy=K;

            }
        }
        return buffer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new A0482LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w",4));
        System.out.println(new A0482LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J",2));
        System.out.println(new A0482LicenseKeyFormatting().licenseKeyFormatting("---aa--aa-a-a----",2));
    }
}
