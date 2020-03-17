import java.sql.SQLOutput;

public class A0665NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if(nums.length<=2){
            return true;
        }
        int descCount=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>nums[i+1]){
                if(++descCount>=2){
                    return false;
                }
                if(i+2>=nums.length||i-1<0||nums[i+2]>=nums[i]||nums[i+1]>=nums[i-1]){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{4,2,3}));
//        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{4,2,1}));
//        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{2,1}));
//        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{1,3,4,3}));
        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{1,3,4,3,4}));//t
        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{1,3,4,3,7}));
        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{1,4,3,4,5}));
        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{3,4,3,4,5}));//t
        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{3,4,3,4,5,3}));//f
        System.out.println(new A0665NondecreasingArray().checkPossibility(new int[]{3,4,2,3,5}));//f
    }
}
