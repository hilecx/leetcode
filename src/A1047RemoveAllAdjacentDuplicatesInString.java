import java.util.Stack;

public class A1047RemoveAllAdjacentDuplicatesInString {

//    最快答案 双指针，牛逼
//    pointer refers to the index to set next character in the output string.
//    i refers to the index of current iteration in the input string.
    public String removeDuplicates2(String S) {
        char[] chars = S.toCharArray();
        int pointer = 0;
        for(int i =0;i < chars.length; i++) {
            if(pointer == 0 || chars[pointer - 1] != chars[i]){
                chars[pointer] = chars[i];
                pointer++;
            } else {
                pointer--;
            }
        }

        return new String(chars, 0, pointer);
    }

    public String removeDuplicates(String S) {
        if(S==null||S.length()==0){
            return S;
        }
        Stack<Character> stack = new Stack<>();
        char[] cs = S.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if(stack.isEmpty()){
                stack.push(cs[i]);
            }else{
                char t=stack.peek();
                if(t==cs[i]){
                    stack.pop();
                }else {
                    stack.push(cs[i]);
                }
            }
        }
        char[] r = new char[stack.size()];
        for (int i = 0; i < r.length; i++) {
            r[i]=stack.get(i);
        }
        return  new String(r);

    }

    public static void main(String[] args) {
        System.out.println(new A1047RemoveAllAdjacentDuplicatesInString().removeDuplicates2("abcddba"));
    }
}
