import java.util.ArrayList;
import java.util.List;

public class A0849MaximizeDistanceClosestPerson {

//抄答案了，这个写法清晰明了，自己做的时候对头尾中间3种情况感到烦躁，今天不在状态啊
    public int maxDistToClosest(int[] seats) {
        int res = 0, n = seats.length, last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, n - last - 1);
        return res;

    }

    public int maxDistToClosest2(int[] seats) {
        List<Integer> seatIndex = new ArrayList<>();

        for (int i = 0; i < seats.length; i++) {
            if(seats[i]==1){
                seatIndex.add(i);
            }
        }

        int firstDis=seatIndex.get(0);
        int lastDis=seats.length+1-seatIndex.get(seatIndex.size()-1);
        int r = Math.max(firstDis,lastDis);
        for (int i = 0; i < seatIndex.size()-1; i++) {
            r = Math.max(r,(seatIndex.get(i+1)-seatIndex.get(i))/2);
        }
        return r;

    }

    public static void main(String[] args) {
        System.out.println(new A0849MaximizeDistanceClosestPerson().maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }
}
