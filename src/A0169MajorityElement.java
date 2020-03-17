import java.util.HashMap;
import java.util.Map;

public class A0169MajorityElement {

//    这题经典，学到几个算法
//    1 Boyer-Moore Voting Algorithm
//    2 Divide and Conquer
    public static void main(String[] args) {
//        System.out.println(new A0169MajorityElement().majorityElement(new int[]{-1,1,1,1,2,1,Integer.MAX_VALUE,Integer.MIN_VALUE}));
        System.out.println(new A0169MajorityElement().majorityElement3(new int[]{-1, 1, 1, 1, 2, 1}));
    }

    //最快的答案 Boyer-Moore Voting Algorithm，似乎只试用于Find Majority Element
//    初始化两个变量 m 和计数器 c，m 的初值为数组第一项，c 的初值为 1
//    从第二项开始遍历数组 nums
//if (c == 0) { m = nums[i]; c= 1; } 如果 c 减为 0 了，则更新 m 为当前正在处理的数
//    否则 if (m == nums[i]) c++; else c--; 当前的数和 m 相同，则 c++ 否则 c--
//            return m
    public int majorityElement3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int majority = nums[0];
        int cout = 1;
        for (int i = 1; i < nums.length; i++) {
            if (majority == nums[i]) {
                cout++;
            } else {
                cout--;
            }
            if (cout == 0) {
                majority = nums[i];
                cout++;
            }
        }
        int count = 0;
        for (int i : nums) {
            if (i == majority) count++;
        }

        return count > nums.length / 2 ? majority : -1;
    }

    public int majorityElement(int[] nums) {
        int m = nums.length / 2;
        int max = 0;
        int min = 0;
        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] countP = new int[max];
        int[] countN;
        if (min < 0) {
            countN = new int[-1 * (min + 1)];
        } else {
            countN = null;
        }
        int count0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && ++countP[nums[i] - 1] > m) {
                return nums[i];
            } else if (min < 0 && nums[i] < 0 && ++countN[-1 * nums[i] - 1] > m) {
                return nums[i];
            } else if (nums[i] == 0 && count0 > m) {
                return 0;
            }
        }
        return 0;
    }

    public int majorityElementMap1(int[] nums) {
        int m = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.compute(nums[i], (Integer key, Integer value) -> (value == null ? 1 : value + 1)) > m) {
                return nums[i];
            }
        }
        return 0;
    }

    public int majorityElementMap2(int[] nums) {
        int m = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>(100000);
        for (int i = 0; i < nums.length; i++) {
            if (map.compute(nums[i], (Integer key, Integer value) -> (value == null ? 1 : value + 1)) > m) {
                return nums[i];
            }
        }
        return 0;
    }
}
