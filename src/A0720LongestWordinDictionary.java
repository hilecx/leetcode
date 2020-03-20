import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A0720LongestWordinDictionary {
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String r = "";
        int maxLength = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 1 || set.contains(words[i].substring(0, words[i].length() - 1))) {
                set.add(words[i]);
                if (words[i].length() > maxLength) {
                    r = words[i];
                    maxLength = words[i].length();
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
//        System.out.println("abc".substring(0, 2));
        System.out.println(new A0720LongestWordinDictionary().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(new A0720LongestWordinDictionary().longestWord(new String[]{"ab", "abc"}));
    }
}
