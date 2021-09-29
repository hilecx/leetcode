public class A2016MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {
        int result = 0;
        result = new A2016MaximumDifferenceBetweenIncreasingElements().maximumDifference(new int[]{43,98,6,40});
        System.out.println(result);
        result = new A2016MaximumDifferenceBetweenIncreasingElements().maximumDifference(new int[]{9, 4, 3, 2});
        System.out.println(result);
        result = new A2016MaximumDifferenceBetweenIncreasingElements().maximumDifference(new int[]{7, 1, 5, 4});
        System.out.println(result);
        result = new A2016MaximumDifferenceBetweenIncreasingElements().maximumDifference(new int[]{1, 5, 2, 10});
        System.out.println(result);
    }

    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int max = 0;
        int result = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                max = nums[i];
            }
            if (nums[i] > max && nums[i] > min) {
                max = nums[i];
            }
            result = Math.max(result, max - min);
        }
        return result>0?result:-1;
    }
}
