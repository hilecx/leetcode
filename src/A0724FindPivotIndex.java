import java.util.Arrays;

public class A0724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int nl = nums.length-1;
        int[] lsum = new int[nl+1];
        int[] rsum = new int[nl+1];
        int prelsum = 0;
        int prersum = 0;
        for (int i = 0; i < nl+1; i++) {
            lsum[i] = prelsum+nums[i];
            prelsum=lsum[i];
            rsum[nl-i] = prersum+nums[nl-i];
            prersum=rsum[nl-i];
        }
        System.out.println(Arrays.toString(lsum));
        System.out.println(Arrays.toString(rsum));
        for (int i = 1; i < nl; i++) {
            if(lsum[i-1]==rsum[i+1]){
                return i;
            }
        }
        if(rsum[1]==0){
            return 0;
        }
        if(lsum[nl-1]==0){
            return nl;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new A0724FindPivotIndex().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(new A0724FindPivotIndex().pivotIndex(new int[]{-1,-1,-1,-1,-1,-1}));
        System.out.println(new A0724FindPivotIndex().pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
        System.out.println(new A0724FindPivotIndex().pivotIndex(new int[]{-2,3,-1,-2,3}));
        System.out.println(new A0724FindPivotIndex().pivotIndex(new int[]{-1,-1,-1,0,1,1}));
    }

}
