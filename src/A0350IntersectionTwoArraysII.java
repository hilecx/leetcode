import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A0350IntersectionTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (!(i==nums1.length||j==nums2.length)) {
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }

        }
        int[] r= new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            r[k]=list.get(k);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new A0350IntersectionTwoArraysII().intersect(new int[]{1,2,2,1,2},new int[]{2,2,1})));
    }
}
