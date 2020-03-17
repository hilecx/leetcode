import java.util.HashMap;
import java.util.Stack;

public class A0496NextGreaterElementI {
//    这个stack解法真的太牛逼了。通过stack生成map，map保存值和右边接近的比它大的值
//    https://leetcode.com/articles/greater-element-i/
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack < Integer > stack = new Stack< >();
        HashMap < Integer, Integer > map = new HashMap< >();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek())
                map.put(stack.pop(), nums[i]);
            stack.push(nums[i]);
        }
        while (!stack.empty())
            map.put(stack.pop(), -1);
        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
}
