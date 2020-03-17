import java.util.Arrays;

public class A0414ThirdMaximumNumber {
    public int thirdMax2(int[] nums) {
        int[] max3 = new int[3];
        //按顺序存最大三个，比大小
        return 0;
    }

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int maxcount = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[nums.length - 1]) {
                maxcount++;
            }
            if (maxcount == 3) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
