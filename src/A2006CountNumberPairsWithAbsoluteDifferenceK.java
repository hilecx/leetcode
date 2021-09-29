import java.util.HashMap;
import java.util.Map;

public class A2006CountNumberPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {
        int result;
        result = new A2006CountNumberPairsWithAbsoluteDifferenceK().countKDifference(new int[]{3,2,1,5,4,1,100},99);
        System.out.println(result);
        result = new A2006CountNumberPairsWithAbsoluteDifferenceK().countKDifference(new int[]{1,2,2,1},1);
        System.out.println(result);
        result = new A2006CountNumberPairsWithAbsoluteDifferenceK().countKDifference(new int[]{1,3},3);
        System.out.println(result);
        result = new A2006CountNumberPairsWithAbsoluteDifferenceK().countKDifference(new int[]{3,2,1,5,4},2);
        System.out.println(result);
    }

    public int countKDifference(int[] nums, int k) {
        int[] map = new int[101];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] ++;
        }
        for (int i = 1; i < map.length; i++) {
            if(i-k >= 1){
                count+=map[i-k] * map[i];
            }
            if(i+k <= 100){
                count+=map[i+k] * map[i];
            }
            map[i]=0;
        }
        return count;
    }
}
