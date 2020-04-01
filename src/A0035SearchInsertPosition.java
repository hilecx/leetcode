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
        new A0035SearchInsertPosition().performanceTest();
//        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,3,5,6},5));
//        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,3,5,6},2));
//        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,3,5,6},7));
//        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,3,5,6},0));
//        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,2,3,5,9},4));
//        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,2,3,5,9},6));
//        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,2,3,4,5,9},6));
//        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{1,2,3,4,5,9},5));
//        System.out.println(new A0035SearchInsertPosition().searchInsert(new int[]{},5));
    }


//    二分查找：初始化变量、运算占用了时间，实际上并没有线性查找快
//    target 10 : 2197
//    target 5000 :2371
//    target 9999 :2781
//    线性查找
//    target 10 : 2172
//    target 5000 :2171
//    target 9999 :2228
    public void performanceTest(){
        int[] a = new int[1000000];
        for (int i = 0; i < a.length; i++) {
            a[i]=i;
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 100; j++) {
                new A0035SearchInsertPosition().searchInsert(a,500000);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
