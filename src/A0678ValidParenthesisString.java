public class A0678ValidParenthesisString {
    public boolean checkValidString(String s) {
        if(s.length()==0){
            return true;
        }
        char[] chars=s.toCharArray();
        if(chars[0]==')' || chars[chars.length-1]=='('){
            return false;
        }
        int left=0;
        int right=0;
        int countstar=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='*'){
                countstar++;
            }else if(chars[i]=='('){
                left++;
            }else {
                right++;
            }
            if(left+countstar<right){
                return false;
            }
        }
        if(Math.abs(left-right)>countstar){
            return false;
        }


         left=0;
         right=0;
         countstar=0;
        for (int i = chars.length-1; i >=0; i--) {
            if(chars[i]=='*'){
                countstar++;
            }else if(chars[i]=='('){
                left++;
            }else {
                right++;
            }
            if(right+countstar<left){
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A0678ValidParenthesisString().checkValidString("*()(())*()(()()((()(()()*)(*(())((((((((()*)(()(*)"));
        System.out.println(new A0678ValidParenthesisString().checkValidString("((())"));
        System.out.println(new A0678ValidParenthesisString().checkValidString("(*))"));
        System.out.println(new A0678ValidParenthesisString().checkValidString("()*))"));
    }
}
