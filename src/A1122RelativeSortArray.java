import java.util.*;

public class A1122RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        Map<Integer,Integer> map = new HashMap<>();
        int[] map = new int[1001];

        int[] r = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            map[arr1[i]]++;
        }

        int j=0;
        for (int i = 0; i < arr2.length; i++) {
            int value = map[arr2[i]];
            for (int k = 1; k <= value; k++) {
                r[j++]=arr2[i];
            }
            map[arr2[i]]=0;
        }

        int s=j;
        for (int i = 0; i < map.length; i++) {
            for (int k = 1; k <= map[i]; k++) {
                r[j++]=i;
            }
        }

        Arrays.sort(r,s,r.length);
        return r;
    }


    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map = new HashMap<>();

        int[] r = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }

        int j=0;
        for (int i = 0; i < arr2.length; i++) {
            int value = map.get(arr2[i]);
            for (int k = 1; k <= value; k++) {
                r[j++]=arr2[i];
            }
            map.remove(arr2[i]);
        }

        int s=j;
        Iterator<Map.Entry<Integer,Integer>> entryIterator= map.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Integer,Integer> entry = entryIterator.next();
            for (int k = 0; k < entry.getValue(); k++) {
                r[j++]=entry.getKey();
            }
        }
        Arrays.sort(r,s,r.length);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new A1122RelativeSortArray().relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6})));
    }
}
