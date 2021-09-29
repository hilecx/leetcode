import java.util.Arrays;

public class A0922SortArrayByParityII {


    public static void main(String[] args) {
        int[] result = null;

        result = new A0922SortArrayByParityII().sortArrayByParityII(new int[]{1, 2});
        System.out.println(Arrays.toString(result));
        result = new A0922SortArrayByParityII().sortArrayByParityII(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(result));
        result = new A0922SortArrayByParityII().sortArrayByParityII(new int[]{4, 2, 5, 7});
        System.out.println(Arrays.toString(result));
        result = new A0922SortArrayByParityII().sortArrayByParityII(new int[]{4,2,5,7,1,1,1,7,7,7,8,8,8,4,4,6});
        System.out.println(Arrays.toString(result));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int[] numsResult = new int[nums.length];
        int o = 1;
        int e = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0){
                numsResult[e]=nums[i];
                e+=2;
            }else {
                numsResult[o]=nums[i];
                o+=2;
            }
        }
        return numsResult;

    }


    int indexOdd = 1;
    int indexEven = 0;
    Integer tmpOdd = null;
    Integer tmpEven = null;
    int[] numsResult;

    public int[] sortArrayByParityII2(int[] nums) {
        numsResult = Arrays.copyOf(nums,nums.length);
        loopEven(nums);
        return numsResult;
    }

    private void loopOdd(int[] nums) {
        if (tmpOdd != null && tmpEven != null) {
            swap(indexOdd, indexEven, tmpOdd, tmpEven, nums);
        }
        for (; indexOdd < nums.length; indexOdd+=2) {
            System.out.println("indexOdd:"+indexOdd);
            if (nums[indexOdd] % 2 == 0) {
                tmpOdd = nums[indexOdd];
                loopEven(nums);
            }
        }

    }

    private void loopEven(int[] nums) {
        if (tmpOdd != null && tmpEven != null) {
            swap(indexOdd, indexEven, tmpOdd, tmpEven, nums);
        }
        for (; indexEven < nums.length; indexEven+=2) {
            System.out.println("indexEven:"+indexEven);
            if (nums[indexEven] % 2 == 1) {
                tmpEven = nums[indexEven];
                loopOdd(nums);
            }
        }

    }

    private void swap(int indexOdd, int indexEven, int tmpOdd, int tmpEven, int[] nums) {
        System.out.println("swap indexOdd:"+indexOdd+"  indexEven:"+indexEven+"  tmpOdd:"+tmpOdd+"  tmpEven:"+tmpEven);
        numsResult[indexOdd] = tmpEven;
        numsResult[indexEven] = tmpOdd;
        this.tmpOdd = null;
        this.tmpEven = null;
        this.indexOdd+=2;
        this.indexEven+=2;
    }


}
