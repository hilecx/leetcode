import java.util.HashMap;
import java.util.Map;

public class A0219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer c = map.get(nums[i]);
            if(c!=null && i-c<=k){
                return true;
            }else {
                    map.put(nums[i],i);
            }
        }
        return false;
    }

//    wrong  when nums is negative...
    public boolean containsNearbyDuplicate2(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max=Math.max(max,nums[i]);
        }
        Integer[] map = new Integer[max+1];
        for (int i = 0; i < nums.length; i++) {
            Integer c = map[nums[i]];
            if(c!=null && i-c<=k){
                return true;
            }else {
                map[nums[i]]=i;
            }
        }
        return false;
    }
}
