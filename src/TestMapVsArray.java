import java.util.HashMap;
import java.util.Map;

public class TestMapVsArray {
    public static void main(String[] args) {
        new TestMapVsArray().vs();
    }

    private void vs(){
        int n = Integer.MAX_VALUE/100;
        Map<Integer,Integer> map = new HashMap<>();
        int[] array = new int[n];
        long time1 =System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            map.put(i,i);
        }
        long time2 =System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            array[i]=i;
        }
        long time3 =System.currentTimeMillis();
        System.out.println(time2-time1);
        System.out.println(time3-time2);

    }
}
