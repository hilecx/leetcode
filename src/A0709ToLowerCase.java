public class A0709ToLowerCase {
    public String toLowerCase(String str) {
        char[] chars=str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]<='Z'&& chars[i]>='A'){
                chars[i]= (char) (chars[i]+32);
            }
        }
        return new String(chars);
    }

}
