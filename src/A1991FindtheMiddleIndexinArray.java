public class A1991FindtheMiddleIndexinArray {
    public static void main(String[] args) {
        int r;
        r = new A1991FindtheMiddleIndexinArray().findMiddleIndex(new int[]{4, 0});
        System.out.println(r);
        r = new A1991FindtheMiddleIndexinArray().findMiddleIndex(new int[]{2, 3, -1, 8, 4});
        System.out.println(r);
        r = new A1991FindtheMiddleIndexinArray().findMiddleIndex(new int[]{1, -1, 4});
        System.out.println(r);
        r = new A1991FindtheMiddleIndexinArray().findMiddleIndex(new int[]{2, 5});
        System.out.println(r);
        r = new A1991FindtheMiddleIndexinArray().findMiddleIndex(new int[]{1});
        System.out.println(r);
    }

    public int findMiddleIndex(int[] nums) {
        int length = nums.length;
        int leftSum = nums[0];
        int[] rightSum = new int[length];
        rightSum[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];

        }
        if (leftSum == rightSum[0]) {
            return 0;
        }
        for (int i = 1; i < length; i++) {
            leftSum += nums[i];
            if (leftSum == rightSum[i]) {
                return i;
            }
        }
        return -1;
    }
}
