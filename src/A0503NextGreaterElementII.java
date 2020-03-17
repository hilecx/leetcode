import java.sql.PseudoColumnUsage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class A0503NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
//        Stack<int[]> stack = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        int[] map = new int[nums.length];
        Arrays.fill(map, -1);
        int maxvalue = Integer.MIN_VALUE;
        int maxindex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxvalue) {
                maxvalue = nums[i];
                maxindex = i;
            }
        }
        int i = maxindex + 1 == nums.length ? 0 : maxindex + 1;
        boolean time1st = true;
        while (i != maxindex || time1st) {
            if (i == maxindex) {
                time1st = false;
            }
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                map[stack.pop()] = nums[i];
            }
            stack.add(i);//key index, value v
            i = i + 1 == nums.length ? 0 : i + 1;
        }
        return map;
    }

    public static void main(String[] args) {
        int[] r1 = new A0503NextGreaterElementII().nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(r1));
        int[] r2 = new A0503NextGreaterElementII().nextGreaterElements(new int[]{1, 2, 1, 3, -8});
        System.out.println(Arrays.toString(r2));
        int[] r3 = new A0503NextGreaterElementII().nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100});
        System.out.println(Arrays.toString(r3));
    }
}
