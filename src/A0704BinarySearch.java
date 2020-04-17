public class A0704BinarySearch {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while (start<=end){
            int m = start+(end-start)/2;
            if(nums[m]>target){
                end=m-1;
                continue;
            }else if (nums[m]<target){
                start=m+1;
                continue;
            }else {
                return m;
            }
        }
        return -1;
    }
}
