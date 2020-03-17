import java.util.Arrays;

public class A283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while (zeroIndex< nums.length) {
                if (nums[zeroIndex] == 0) {
                    break;
                } else {
                    zeroIndex++;
                    continue;
                }
            }
            if (nums[i] != 0) {
                if (i > zeroIndex) {
                    int tmp = nums[zeroIndex];
                    nums[zeroIndex] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new A283MoveZeroes().moveZeroes(new int[]{0});
        new A283MoveZeroes().moveZeroes(new int[]{1, 0, 1, 0,0, 3, 12});
    }
}
