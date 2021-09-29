import java.util.Arrays;

public class A1480RunningSum1dArray {
    public int[] runningSum2(int[] nums) {
        int[] r = new int[nums.length];
        int s = nums[0];
        r[0] = s;
        for (int i = 1; i < nums.length; i++) {
            r[i] = nums[i]+s;
            s = r[i];
        }
        return r;
    }

    public int[] runningSum(int[] nums) {
//        int[] r = new int[nums.length];
//        int s = nums[0];
//        r[0] = s;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i]+nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = new A1480RunningSum1dArray().runningSum(new int[]{1,2,3,4,6});
        System.out.println(Arrays.toString(a));
        a = new A1480RunningSum1dArray().runningSum(new int[]{1});
        System.out.println(Arrays.toString(a));
        a = new A1480RunningSum1dArray().runningSum(new int[]{1,-2,3,4,6});
        System.out.println(Arrays.toString(a));
        a = new A1480RunningSum1dArray().runningSum(new int[]{1,2,3,4,-16});
        System.out.println(Arrays.toString(a));
    }
}
