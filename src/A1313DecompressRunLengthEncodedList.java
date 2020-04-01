import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A1313DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            size+=nums[i];
        }
        int[] r=new int[size];
        int ri=0;
        for (int i = 0; i < nums.length; i=i+2) {
            for (int j = 0; j < nums[i]; j++) {
                r[ri++]=nums[i+1];
            }
        }
        return r;
    }


    public int[] decompressRLElist2(int[] nums) {
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < nums.length; i=i+2) {
            for (int j = 0; j < nums[i]; j++) {
                r.add(nums[i+1]);
            }
        }
        int[] rr = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            rr[i]=r.get(i);
        }
        return rr;
    }
}
