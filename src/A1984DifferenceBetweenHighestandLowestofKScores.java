import java.util.Arrays;

public class A1984DifferenceBetweenHighestandLowestofKScores {
    public static void main(String[] args) {

        int r;
        r = new A1984DifferenceBetweenHighestandLowestofKScores().minimumDifference(new int[]{9, 4, 1, 7}, 2);
        System.out.println(r);
        r = new A1984DifferenceBetweenHighestandLowestofKScores().minimumDifference(new int[]{9}, 1);
        System.out.println(r);
    }

    public int minimumDifference(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - k + 1; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}
