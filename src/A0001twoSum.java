import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A0001twoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

//    利用map减少n平方到n
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(10000);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { map.get(complement),i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] r=new A0001twoSum().twoSum(new int[]{2,7,11,15},9);
        System.out.println(Arrays.toString(r));
        int[] r2=new A0001twoSum().twoSum2(new int[]{2,7,11,15},9);
        System.out.println(Arrays.toString(r2));
    }


//    The second train of thought is, without changing the array,
//    can we use additional space somehow?
//    Like maybe a hash map to speed up the search?
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }

}
