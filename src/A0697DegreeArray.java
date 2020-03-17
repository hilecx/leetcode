import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A0697DegreeArray {

    //    根据答案优化
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> startIndex = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        int maxCount = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            startIndex.compute(nums[i], (Integer key, Integer value) -> (value == null ? finalI : value));
            int counti = count.compute(nums[i], (Integer key, Integer value) -> (value == null ? 1 : value + 1));
            int thisDis = i - startIndex.get(nums[i]);
            if (maxCount < counti) {
                maxCount = counti;
                minDistance = thisDis;
            } else if (maxCount == counti && thisDis < minDistance) {
                minDistance = thisDis;
            }
        }

        return minDistance + 1;

    }

    //    自己写的map解法
    public int findShortestSubArray2(int[] nums) {
        Map<Integer, Integer> startIndex = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> distance = new HashMap<>();
        int maxCount = 0;
        List<Integer> maxNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            startIndex.compute(nums[i], (Integer key, Integer value) -> (value == null ? finalI : value));
            int counti = count.compute(nums[i], (Integer key, Integer value) -> (value == null ? 1 : value + 1));
//            maxCount=Math.max(maxCount,counti);
            if (maxCount <= counti) {
                distance.put(nums[i], i - startIndex.get(nums[i]));
                maxCount = counti;
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry entry : count.entrySet()) {
            int d = (Integer) entry.getValue();
            Integer diskey = distance.get(entry.getKey());
            if (d == maxCount && diskey != null) {
                minDistance = Math.min(minDistance, distance.get(entry.getKey()));
            }
        }
        return minDistance + 1;

    }

    //   最快的答案，可以看到数组比我的map快很多
    public int findShortestSubArray3(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        int[] counts = new int[max + 1];
        int biggestCount = 0;

        int[] firstIndex = new int[max + 1];

        int shortestSubarray = Integer.MAX_VALUE;

        for (int index = 0; index < nums.length; index++) {
            int i = nums[index];
            if (firstIndex[i] == 0) {
                firstIndex[i] = index + 1;
            }

            int count = ++counts[i];

            int len = index - firstIndex[i] + 2;

            if (count > biggestCount) {
                biggestCount = count;
                shortestSubarray = len;
            } else if (count == biggestCount && shortestSubarray > len) {
                shortestSubarray = len;
            }
        }

        return shortestSubarray;
    }

    public static void main(String[] args) {
        System.out.println(new A0697DegreeArray().findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(new A0697DegreeArray().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
}
