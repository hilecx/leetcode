import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A1200MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            min=Math.min(min,arr[i]-arr[i-1]);
        }
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-arr[i-1]==min){
                r.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return r;
    }
}
