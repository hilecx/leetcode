public class A0268MissingNumber {
//    常规解法，用set，不写了
//    这个位运算解法真的太绝了
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

//Gauss' Formula 这个是小学生的正常解法啊，长大反而忘了
    public int missingNumber2(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
