import java.util.Arrays;

//本质上是双指针法
public class A0026RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int count = 0;
        int cval = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(i>count && nums[i] != cval){
                cval=nums[i];
                int tmp = nums[count+1];
                nums[count+1]=nums[i];
                nums[i]=tmp;
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return count+1;
    }

    public static void main(String[] args) {
        System.out.println(new A0026RemoveDuplicatesfromSortedArray().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
