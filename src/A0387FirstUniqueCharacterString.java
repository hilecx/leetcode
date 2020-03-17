import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class A0387FirstUniqueCharacterString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (Character key, Integer value) -> (value == null ? 1 : value + 1));
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        char[] chars = s.toCharArray();
        int[] array = new int[123];
        for (int i = 0; i < s.length(); i++) {
            char t = chars[i];
            if (array[t] <= 1) {
                array[t]++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
