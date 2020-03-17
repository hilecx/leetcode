import java.util.HashMap;
import java.util.Map;

public class A0167TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
//        int endIndex = numbers.length-1;
//        int midIndex = numbers.length/2;
//        while(numbers[endIndex]>target){
//
//        }
        int i=0;
        int j=numbers.length-1;
        int sumTmp = numbers[i]+numbers[j];
        while(sumTmp!=target){
            if(numbers[j]>target||sumTmp>target){
                sumTmp = numbers[j--]+numbers[i];
                continue;
            }
            if(sumTmp<target){
                sumTmp = numbers[j]+numbers[i++];
                continue;
            }
        }
        return new int[]{i,j};
    }

//    twosum1的方法
    public int[] twoSum2(int[] numbers, int target) {
        int[] r = new int[2];
        Map<Integer, Integer> map = new HashMap<>();//value index
        for (int i = 0; i < numbers.length; i++) {
            int m = target - numbers[i];
            if (map.get(m) != null) {
                r[0] = map.get(m);
                r[1] = i;
                break;
            }

            if (map.get(numbers[i]) == null) {
                map.put(numbers[i], i);
            }
        }
        return r;
    }
}
