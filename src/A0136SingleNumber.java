public class A0136SingleNumber {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r^=nums[i];
        }
        return r;
    }
}
