import java.util.Arrays;
import java.util.EmptyStackException;

public class A0238ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] r = new int[nums.length];
        r[0]=nums[0];
        for (int i = 1; i < r.length; i++) {
            r[i]=r[i-1]*nums[i];
        }
        for (int i = nums.length-2; i >=0 ; i--) {
            nums[i]=nums[i]*nums[i+1];
        }
        System.out.println(Arrays.toString(r));
        System.out.println(Arrays.toString(nums));
        int tmp;
        int pre=1;
        for (int i = 0; i < r.length; i++) {
            tmp=r[i];
            if(i==0){
                r[i]=nums[1];
            }else if(i==r.length-1){
                r[i]=pre;
            }else {
                r[i]=pre*nums[i+1];
            }
            pre=tmp;
            System.out.println(Arrays.toString(r));
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new A0238ProductArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4})));
    }
}
