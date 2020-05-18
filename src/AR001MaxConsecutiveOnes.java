//https://leetcode.com/explore/featured/card/fun-with-arrays/521/introduction/3238/
public class AR001MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int r=0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                r++;
            }else{
                max = Math.max(max,r);
                r=0;
            }
        }
        return Math.max(max,r);
    }

    public static void main(String[] args) {
        System.out.println(new AR001MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(new AR001MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{0}));
        System.out.println(new AR001MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1}));
    }
}
