import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A0475Heaters {
    //brute force
    public int findRadius2(int[] houses, int[] heaters) {
        int r = 0;
        for (int i = 0; i < houses.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                min = Math.min(min, Math.abs(houses[i] - heaters[j]));
            }
            r = Math.max(r, min);
        }
        return r;

    }
//Time Limit Exceeded
    public int findRadius3(int[] houses, int[] heaters) {
        Set<Integer> houseSet=new HashSet<>();
        for (int i = 0; i < houses.length; i++) {
            houseSet.add(houses[i]);
        }
        int r=0;
        while (true){
            for (int i = 0; i < heaters.length; i++) {
                houseSet.remove(heaters[i]+r);
                houseSet.remove(heaters[i]-r);
            }
            if(houseSet.isEmpty()){
                break;
            }
            r++;
        }
        return r;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        heaters = Arrays.stream(heaters).distinct().toArray();
        int i=0;
        int j=0;
        int r=0;
        int maxj=heaters.length-1;
        while (j<heaters.length&&i<houses.length){
            if(j<maxj){
                if(heaters[j]==heaters[j+1]){
                    j++;
                    continue;
                }
                int diff1 = Math.abs(houses[i]-heaters[j]);
                int diff2 = Math.abs(houses[i]-heaters[j+1]);
                if(diff1<=diff2){
                    r=Math.max(diff1,r);
                    i++;
                }else {
                    j++;
                }
            }else {
                r=Math.max(Math.abs(houses[i]-heaters[j]),r);
                i++;
            }
        }
        return r;
    }


        public static void main(String[] args) {

    }
}
