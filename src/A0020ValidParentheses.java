import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class A0020ValidParentheses {


    public boolean isValid(String s) {
//        if(s==null || s.length()==0){
//            return true;
//        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();// 计算一次即可
        for (int i = 0; i < s.length(); i++) {
            Character k = chars[i];
            Character c = map.get(k);
            if (c == null) { //k = [{(
                stack.push(k);
            } else { //k=]})  c = [{(
                if (stack.isEmpty()) {
                    return false;
                }
                if (!c.equals(stack.pop())) {//
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(new A0020ValidParentheses().isValid("(("));
        System.out.println(new A0020ValidParentheses().isValid("()[]{}"));
        System.out.println(new A0020ValidParentheses().isValid("(]"));
        System.out.println(new A0020ValidParentheses().isValid("([)]"));
        System.out.println(new A0020ValidParentheses().isValid("{[]}"));
    }
}
