import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A1002FindCommonCharacters {

    public List<String> commonChars2(String[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        List<String> list = new ArrayList<>();
        Map<Character, Integer> cmap = new HashMap<>();//用int[][]实现更快
        char[] chars = A[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            cmap.put(Character.valueOf(chars[i]), cmap.getOrDefault(chars[i], 0) + 1);
        }
        for (int i = 1; i < A.length; i++) {
            char[] c = A[i].toCharArray();
            Map<Character, Integer> newmap = new HashMap<>();//用int[][]实现更快
            Map<Character, Integer> map = new HashMap<>();//用int[][]实现更快
            for (int j = 0; j < c.length; j++) {
                map.put(Character.valueOf(c[j]), map.getOrDefault(c[j], 0) + 1);
            }
            for (Character character : map.keySet()) {
                newmap.put(character, Math.min(map.get(character), cmap.getOrDefault(character, 0)));
            }
            cmap = newmap;
        }
        for (Character i : cmap.keySet()) {
            int c = cmap.get(i);
            if (c > 0) {
                for (int j = 0; j < c; j++) {
                    list.add(i.toString());
                }
            }
        }
        return list;
    }

    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        List<String> list = new ArrayList<>();
        char[] cmap = new char[127];
        char[] chars = A[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            cmap[chars[i]]++;
        }
        char[] c;
        char[] newmap;
        char[] map;
        for (int i = 1; i < A.length; i++) {
            c = A[i].toCharArray();
            newmap = new char[127];
            map = new char[127];
            for (int j = 0; j < c.length; j++) {
                map[c[j]]++;
            }
            for (int j = 0; j < map.length; j++) {
                if (map[j] > cmap[j]) {
                    newmap[j] = cmap[j];
                } else {
                    newmap[j] = map[j];

                }
            }
            cmap = newmap;
        }
        for (int i = 0; i < cmap.length; i++) {
            if (cmap[i] > 0) {
                for (int j = 0; j < cmap[i]; j++) {
                    list.add((String.valueOf((char) i)));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new A1002FindCommonCharacters().commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(new A1002FindCommonCharacters().commonChars(new String[]{"cool", "lock", "cook"}));
    }
}
