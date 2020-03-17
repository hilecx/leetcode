import java.util.ArrayList;
import java.util.List;

public class A0448FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] s = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            s[nums[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < s.length; i++) {
            if(s[i]==0) {
                list.add(i);
            }
        }
        return list;
    }
}
