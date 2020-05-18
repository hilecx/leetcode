import java.util.*;

public class A0015ThreeSum {


//    public List<List<Integer>> threeSum2(int[] nums) {
//        Arrays.sort(nums);
//        int s = 0;
//        int e = nums.length-1;
//        int m;
//        while (true){
//            if(nums[s]+nums[e]<0)
//        }
//    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new A0015ThreeSum().threeSum(new int[]{-1,0,-2,2,-1,-4});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf("%d\t",integer);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Set<Pair>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int diff = 0-nums[i]-nums[j];
                Set<Pair> set = map.getOrDefault(diff,new HashSet<>());
                set.add(new Pair(nums[i],nums[j]));
                map.put(diff,set);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                Set<Pair> pairSet = map.get(nums[i]);
                for (Pair pair : pairSet) {
                    if(i!=pair.i &&i!=pair.j){
                        list.add(Arrays.asList(nums[i],pair.i,pair.j));
                    }
                }
            }
        }
        return list;
    }

    class Pair{
        int i;
        int j;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return i<j?Objects.hash(i, j):Objects.hash(j, i);
        }

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
