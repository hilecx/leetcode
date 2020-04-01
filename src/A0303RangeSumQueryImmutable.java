import java.util.Map;

public class A0303RangeSumQueryImmutable {
    class NumArray {
        int[] nums;
        Integer[][] s;
        public NumArray(int[] nums) {
            this.nums=nums;
            s=new Integer[nums.length][nums.length];
        }

        public int sumRange(int i, int j) {
            if(s[i][j]!=null){
                return s[i][j];
            }
            int sum=0;
            for (int k = i; k <=j ; k++) {
                sum+=nums[k];
            }
            s[i][j]=sum;
            return sum;
        }
    }
}
