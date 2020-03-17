import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class A0290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] s = str.split(" ");
        if (p.length != s.length) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
//     @return the previous value associated with <tt>key</tt>, or <tt>null</tt> if there was no mapping for <tt>key</tt>.
//     (A <tt>null</tt> return can also indicate that the map previously associated <tt>null</tt> with <tt>key</tt>.)
//      map.put居然返回key之前的value。
        for (int i = 0; i < p.length; i++) {
            if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(s[i], i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new A0290WordPattern().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new A0290WordPattern().wordPattern("abba", "dog dog dog dog"));
        System.out.println(new A0290WordPattern().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new A0290WordPattern().wordPattern("aaaa", "dog dog dog"));
        System.out.println(new A0290WordPattern().wordPattern("aaab", "dog dog dog ca"));
        System.out.println(new A0290WordPattern().wordPattern("", ""));
    }
}
