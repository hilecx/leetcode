import java.util.Arrays;

public class A0088MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // map pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }

    public static void main(String[] args) {
//抄了官方答案： 双指针，注意： 1 可以从后往前； 2 已排序部分不需要再排，只要copy

    }

    //击败100%  但是太复杂了
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        if(m==0){
            System.arraycopy(nums2,0,nums1,0,nums2.length);
            return;
        }

        int[] numnew = new int[nums1.length];
        int index = 0;
        int mi = 0;
        int ni = 0;
        while (mi < m && ni < n) {
            if(nums1[mi]<nums2[ni]){
                numnew[index] = nums1[mi];
                mi++;
            }else {
                numnew[index] = nums2[ni];
                ni++;
            }
            index++;
        }
        //System.out.println(Arrays.toString(numnew));
        if(mi<=m-1){
            System.arraycopy(nums1,mi,numnew,index,m-mi);
        }
        //System.out.println(Arrays.toString(numnew));

        if(ni<=n-1){
            System.arraycopy(nums2,ni,numnew,index,n-ni);
        }
        System.arraycopy(numnew,0,nums1,0,numnew.length);
        //System.out.println(Arrays.toString(numnew));

    }
}