public class A0058LengthLastWord {
    public int lengthOfLastWord1(String s) {
        if(s==null ||s.length()==0){
            return 0;
        }
        char[] chars = s.trim().toCharArray();
        for (int i = chars.length-1; i >=0 ; i--) {
            if(chars[i] == ' '){
                return chars.length-i-1;
            }
        }
        return chars.length;
    }

    public int lengthOfLastWord(String s) {
        if(s==null ||s.length()==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int num=0;
        for (int i = chars.length-1; i >=0 ; i--) {
            if(chars[i] != ' '){
                num++;
            }else if (num>0){
                return num;
            }
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(new A0058LengthLastWord().lengthOfLastWord("aasdfdf "));
        System.out.println(new A0058LengthLastWord().lengthOfLastWord("Hewe asdf"));
        System.out.println(new A0058LengthLastWord().lengthOfLastWord(""));
        System.out.println(new A0058LengthLastWord().lengthOfLastWord("aasdfdf"));

    }
}
