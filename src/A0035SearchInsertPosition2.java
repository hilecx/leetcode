public class A0035SearchInsertPosition2 {
    public int searchInsert(int[] nums, int target) {
        if(nums==null){
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if(target<nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        new A0035SearchInsertPosition().performanceTest();
    }

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
                new A0035SearchInsertPosition().searchInsert(a,9999);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
