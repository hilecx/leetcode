public class A0246StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        char[] chars=num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j=num.length()-i-1;
            if(chars[i]=='0'&&chars[j]=='0'){
                continue;
            }else if(chars[i]=='1'&&chars[j]=='1'){
                continue;
            }else if(chars[i]=='8'&&chars[j]=='8'){
                continue;
            }else if(chars[i]=='6'&&chars[j]=='9'){
                continue;
            }else if(chars[i]=='9'&&chars[j]=='6'){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    private boolean is018(char x){
        return x=='0'||x=='1'||x=='8';
    }
    private boolean is69(char x){
        return x=='6'||x=='0';
    }
}
