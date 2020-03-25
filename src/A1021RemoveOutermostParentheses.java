import java.util.*;

public class A1021RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        int count=0;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='('){
                count++;
                if(count!=1){
                    buffer.append(chars[i]);
                }
            }

            if(chars[i]==')'){
                count--;
                if(count!=0){
                    buffer.append(chars[i]);
                }
            }
        }
        return buffer.toString();
    }


    public String removeOuterParentheses2(String S) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        Stack<Character> stack = new Stack<>();
        char[] chars = S.toCharArray();
        List<Integer> delIndex = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            Character c = map.get(chars[i]);
            if(c==null){
                if(stack.isEmpty()){
                    delIndex.add(i);
                }
                stack.push(chars[i]);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    delIndex.add(i);
                }
            }
        }

        System.out.println(Arrays.toString(delIndex.toArray()));
        StringBuffer buffer = new StringBuffer(S);
        for (int i = delIndex.size()-1; i >=0; i--) {
            buffer.deleteCharAt(delIndex.get(i));
        }
        return buffer.toString();
    }
    public static void main(String[] args) {
        System.out.println(new A1021RemoveOutermostParentheses().removeOuterParentheses("(()())((()))"));
    }
}
