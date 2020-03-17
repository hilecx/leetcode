import java.util.*;

public class A0819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String rString = null;
        int maxoccur = 0;
        Map<String, Integer> map = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            bannedSet.add(banned[i].toLowerCase());
        }
//        paragraph = paragraph.replaceAll("[!?',;.]"," ");
//        String[] parray = paragraph.toLowerCase().split(" ");
        paragraph = paragraph.replaceAll("[ !?',;.]+", " ").toLowerCase();
        String[] parray = paragraph.split(" ");
        for (int i = 0; i < parray.length; i++) {
            String lowerP = parray[i];
            if (bannedSet.contains(lowerP)) {
                continue;
            }
            Integer count = map.compute(lowerP, (String key, Integer value) -> (value == null ? 1 : value + 1));
            if (count > maxoccur) {
                maxoccur = count;
                rString = lowerP;
            }
        }
        return rString;
    }

    //这个方法慢一点，但是这个值得学习
    // Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    public String mostCommonWord2(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
