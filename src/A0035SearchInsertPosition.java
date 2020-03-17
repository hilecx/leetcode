public class A0035SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max = nums.length;
        int min = -1;
        while (max - min != 0){
            if(max - min == 1){
                return max;
            }
            int cut = (max-min)/2 + min;
            if(nums[cut] == target){
                return cut;
            }else if(nums[cut]>target){
                max =cut;
            }else if(nums[cut]<target){
                min =cut;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,3,5,6},5));
        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,3,5,6},2));
        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,3,5,6},7));
        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,3,5,6},0));
        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,2,3,5,9},4));
        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,2,3,5,9},6));
        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,2,3,4,5,9},6));
        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,2,3,4,5,9},5));
        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{},5));
    }
}
