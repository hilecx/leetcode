import java.util.*;

public class A0349IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> rs = new HashSet<>();
        for (int i = 0; i <nums1.length ; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                rs.add(nums2[i]);
            }
        }
        int[] r = new int[rs.size()];
        int i = 0;
        Iterator it = rs.iterator();
        while (it.hasNext()){
            r[i++] = (int) it.next();
        }
        return r;
    }
}
