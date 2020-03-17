import com.sun.org.apache.regexp.internal.REUtil;

public class A0453MinimumMovesEqualArrayElements {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i],min);
            sum+=nums[i];
        }
        return sum-min*nums.length;
    }

    public static void main(String[] args) {
        System.out.println(new A0453MinimumMovesEqualArrayElements().minMoves(new int[]{1,3,3,5,2,3}));
    }
}
