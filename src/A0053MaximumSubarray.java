public class A0053MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = res;
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new A0053MaximumSubarray().maxSubArray(new int[]{-2, -1, -3, 4, -1, 2, 1, -5, 4}));
    }
}