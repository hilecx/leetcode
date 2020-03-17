import java.util.ArrayList;
import java.util.List;

public class A0243ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = words.length;
        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1.add(i);
            } else if (words[i].equals(word2)) {
                index2.add(i);
            }
        }

        for (Integer i1 : index1) {
            for(Integer i2:index2){
                minDistance = Math.min(Math.abs(i2-i1),minDistance);
            }
        }
        return minDistance;
    }
}
