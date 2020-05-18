import java.util.HashMap;
import java.util.Map;

public class A0560SubarraySumEqualsK {
    //超时了
    public int subarraySum(int[] nums, int k) {
        int count=0;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
//        map1.put(nums[0],1);
        for (int i = 0; i < nums.length; i++) {
            for (Integer key : map1.keySet()) {
                map2.put(nums[i]+key,map1.get(key));
            }
            map2.put(nums[i],map2.getOrDefault(nums[i],0)+1);
            count+=map2.getOrDefault(k,0);
            System.out.printf("count:%d, k:%d\n",count,k);
            map1=map2;
            map2=new HashMap<>();
        }
        return count;
    }
//官方solution  O(n)
    public int subarraySum2(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new A0560SubarraySumEqualsK().subarraySum(new int[]{1,1,1,1},1));
        System.out.println(new A0560SubarraySumEqualsK().subarraySum(new int[]{1,1,1,2,0},2));
        System.out.println(new A0560SubarraySumEqualsK().subarraySum(new int[]{1,1,1,2,0,4,-2},2));

    }
}
