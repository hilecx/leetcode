import com.sun.org.apache.xpath.internal.SourceTree;

public class A1995CountSpecialQuadruplets {
    public static void main(String[] args) {
        int r ;
        r = new A1995CountSpecialQuadruplets().countQuadruplets(new int[]{1,2,3,6});
        System.out.println(r);
        r = new A1995CountSpecialQuadruplets().countQuadruplets(new int[]{3,3,6,4,5});
        System.out.println(r);
        r = new A1995CountSpecialQuadruplets().countQuadruplets(new int[]{1,1,1,3,5});
        System.out.println(r);
    }

    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {

                for (int k = j + 1; k < nums.length - 1; k++) {

                    for (int l = k + 1; l < nums.length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
