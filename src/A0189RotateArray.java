import java.util.Arrays;

public class A0189RotateArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 8};
        new A0189RotateArray().rotate3(array, 11);
        System.out.println(Arrays.toString(array));
    }

//    这个方法太清晰了，聪明绝顶，居然没观察出来
//假设输入 1，2，3，4，5，6     2
//1  4，3，2，1，5，6
//2  4，3，2，1，6，5
//3  5，6，1，2，3，4
    public void rotate3(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private void reverse(int[] nums, int i, int j) {
        int tmp = 0;
        while (i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
            System.out.println("abcd");

        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0 || k % nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int start = 0;
        int end = nums.length - 1;
        int mid = nums.length - k;
        while (true) {
            int l = mid - start;
            int r = end - mid + 1;
            int t = r - l;//-1 前面长 0 一样长 1 后面长
            int switchlength = Math.min(l, r);
            if (t < 0) {
                for (int i = 0; i < switchlength; i++) {
                    switchArray(nums, end, end - switchlength);
                    end--;
                }
                mid = end + 1 - switchlength;
            } else {
                for (int i = 0; i < switchlength; i++) {
                    switchArray(nums, start, start + switchlength);
                    start++;
                }
                if (t == 0) {
                    return;
                } else {
                    mid = start + switchlength;
                }
            }
        }
    }


    private void switchArray(int[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
        System.out.println("abcd");
    }
}
