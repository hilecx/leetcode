import java.util.Arrays;
//注意：题目不需要保持所有元素，仅需保留与val不同的，其它随意
public class A0027RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j; ) {
            if (nums[j] == val) {
                j--;
                continue;
            }
            if (nums[i] == val) {
//                int tmp = nums[i];
                nums[i] = nums[j];
//                nums[j] = tmp;
                j--;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
        return j+1;

    }

    public static void main(String[] args) {

        System.out.println(new A0027RemoveElement().removeElement(new int[]{0,1,2,2,3,0,4,2},2));
        System.out.println(new A0027RemoveElement().removeElement(new int[]{3,2,2,3},3));
        System.out.println(new A0027RemoveElement().removeElement(new int[]{3},3));
        System.out.println(new A0027RemoveElement().removeElement(new int[]{4},3));

    }
}
