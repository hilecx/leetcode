import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

public class A0937ReorderDatainLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        if (logs == null) {
            return null;
        }
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // a-z vs a-z
                // a-z vs 0-9
                // 0-9 vs 0-9
                String[] s1array = o1.split(" ", 2);
                String[] s2array = o2.split(" ", 2);
                String s1h = s1array[0];
                String s2h = s2array[0];
                String s1 = s1array[1];
                String s2 = s2array[1];
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                if (c1 > 60 && c2 > 60) {
                    if (s1.equals(s2)) {
                        return s1h.compareTo(s2h);
                    } else {
                        return s1.compareTo(s2);
                    }
                } else if (c1 > 60 && c2 < 60) {
                    return -1;
                } else if (c1 < 60 && c2 > 60) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return logs;
    }

    public String[] reorderLogFiles2(String[] logs) {
        if (logs == null) {
            return null;
        }
        Map<String, String[]> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            map.put(logs[i], logs[i].split(" ", 2));
        }

        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // a-z vs a-z
                // a-z vs 0-9
                // 0-9 vs 0-9
//                String[] s1array = o1.split(" ", 2);
//                String[] s2array = o2.split(" ", 2);
                String[] s1array = map.get(o1);
                String[] s2array = map.get(o2);
                String s1h = s1array[0];
                String s2h = s2array[0];
                String s1 = s1array[1];
                String s2 = s2array[1];
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                if (c1 > 60 && c2 > 60) {
                    if (s1.equals(s2)) {
                        return s1h.compareTo(s2h);
                    } else {
                        return s1.compareTo(s2);
                    }
                } else if (c1 > 60 && c2 < 60) {
                    return -1;
                } else if (c1 < 60 && c2 > 60) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return logs;

    }

    public static void main(String[] args) {
        System.out.println("wfefw awef wefwef wfwe".split("\\s", 2)[1]);
    }


}
