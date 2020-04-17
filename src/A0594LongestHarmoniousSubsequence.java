import java.util.HashMap;
import java.util.Map;

public class A0594LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        for (Integer integer : map.keySet()) {
            if (map.containsKey(integer - 1)) {
                max = Math.max(max, map.get(integer) + map.get(integer - 1));
            }
            if (map.containsKey(integer + 1)) {
                max = Math.max(max, map.get(integer) + map.get(integer + 1));
            }
        }
        return max;
    }
}
