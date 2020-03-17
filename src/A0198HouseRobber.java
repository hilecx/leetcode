import java.util.Arrays;

public class A0198HouseRobber {
    int r = 0;
    int[] s;

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        s = new int[nums.length];
        Arrays.fill(s, -1);
        r = Math.max(findMax(nums, 0), findMax(nums, 1));
//        r = findMax(nums,0);
        return r;
    }

    private int findMax(int[] nums, int startIndex) {
        if (startIndex >= nums.length) {
            return 0;
        }
        int x;
        if (s[startIndex] >= 0) {
            x = s[startIndex];
        } else {
            x = nums[startIndex] + Math.max(findMax(nums, startIndex + 3), findMax(nums, startIndex + 2));
            s[startIndex] = x;
        }
        r = Math.max(r, x);
        return x;
    }

    //Let us look at the case n = 1, clearly f(1) = A1.
//Now, let us look at n = 2, which f(2) = max(A1, A2).
//For n = 3, you have basically the following two options:
//Rob the third house, and add its amount to the first house's amount.
//Do not rob the third house, and stick with the maximum amount of the first two houses.
//Clearly, you would want to choose the larger of the two options at each step.
//Therefore, we could summarize the formula as following:f(k) = max(f(k – 2) + Ak, f(k – 1))
    public int rob3(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] s = new int[nums.length];
        s[0] = nums[0];
        s[1] = Math.max(nums[1],nums[0]);
        int r = 0;
        for (int i = 2; i < nums.length; i++) {
            s[i] = Math.max(s[i-1],nums[i]+s[i-2]);

        }
        return Math.max(s[nums.length-1],s[nums.length-2]);
    }


    public static void main(String[] args) {
        System.out.println(new A0198HouseRobber().rob(new int[]{2, 1, 1, 2}));
        System.out.println(new A0198HouseRobber().rob(new int[]{2, 1, 1, 99}));
        System.out.println(new A0198HouseRobber().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new A0198HouseRobber().rob(new int[]{1, 2}));
        System.out.println(new A0198HouseRobber().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new A0198HouseRobber().rob(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}
