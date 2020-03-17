public class A0581ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int i = 0;
        int j = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //左边开始找到第一个未排序的i
        while (true) {
            if (i + 1 == nums.length || nums[i + 1] < nums[i]) {
                break;
            }
            i++;
        }
        //如果走到最后说明都排序了
        if (i == j) {
            return 0;
        }
        //左边开始找到最后个未排序的j
        while (true) {
            if (j == i || nums[j - 1] > nums[j]) {
                break;
            }
            j--;
        }
        //找到未排序的范围内（i-j）的最大最小值
        for (int k = i; k <= j; k++) {
            min = Math.min(nums[k], min);
            max = Math.max(nums[k], max);
        }
        //往前往后找再最大最小范围内的值，注意等于号的使用
        for (int k = i - 1; k >= 0; k--) {
            if (nums[k] > min && nums[k] <= max) {
                i--;
            }
        }
        for (int k = j + 1; k < nums.length; k++) {
            if (nums[k] >= min && nums[k] < max) {
                j++;
            }
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        System.out.println(new A0581ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(new A0581ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2, 4, 6, 4, 8, 10, 3, 4, 15}));
        System.out.println(new A0581ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1}));
        System.out.println(new A0581ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1, 2}));
        System.out.println(new A0581ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{3, 2}));
    }
}
