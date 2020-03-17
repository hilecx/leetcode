import com.sun.org.apache.regexp.internal.REUtil;

import java.util.HashMap;
import java.util.Map;

public class A0532KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        if (k == 0) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    count++;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (map.containsKey(entry.getValue() + k)) {
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                Math.abs(2 - Integer.MIN_VALUE));
        System.out.println(
                Math.abs(Integer.MIN_VALUE - 2));
    }
}
