import java.util.HashMap;
import java.util.Map;

public class A0525ContiguousArray {
    public int findMaxLength(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] array = new int[nums.length+1];
        array[0]=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                array[i+1]=array[i]-1;
            }else{
                array[i+1]=array[i]+1;
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        for (int i = 0; i < array.length; i++) {
            Integer index=map.get(array[i]);
            if(index==null){
                map.put(array[i],i);
            }else {
                max=Math.max(max,i-index);
            }
        }
        return max;
    }
}
