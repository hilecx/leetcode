
public class A0674LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = 1;
        int max = length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                length++;
            } else {
                max = Math.max(max, length);
                length = 1;
            }
        }
        max = Math.max(max, length);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new A0674LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new A0674LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{2, 2, 2, 2}));
    }
}
