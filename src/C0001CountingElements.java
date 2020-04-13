import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3289/
public class C0001CountingElements {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i]+1)){
                count++;
            }
        }
        return count;
    }
}
