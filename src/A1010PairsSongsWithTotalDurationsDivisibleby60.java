import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A1010PairsSongsWithTotalDurationsDivisibleby60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] a = new int[60];
        for (int i = 0; i < time.length; i++) {
            a[time[i] % 60]++;
        }

        int r = 0;
        int s = 0;
        for (int i = 1; i <= 29; i++) {
            s += a[60 - i] * a[i];
        }

        r += (a[0] - 1) * a[0] / 2;
        r += (a[30] - 1) * a[30] / 2;
        return r + s;
    }

    Map<Integer, Integer> dic = new HashMap<>();

    int sum(int i) {
        if (!dic.containsKey(i)) {
            int r = 0;
            for (int j = 1; j <= i; j++) {
                r += j;
            }
            dic.put(i, r);
        }
        return dic.get(i);
    }

    public static void main(String[] args) {
        int a = new A1010PairsSongsWithTotalDurationsDivisibleby60().numPairsDivisibleBy60(new int[]{1, 35, 6, 5, 34, 5, 323, 4, 23, 64});
        int b = new A1010PairsSongsWithTotalDurationsDivisibleby60().numPairsDivisibleBy60(new int[]{60, 60, 60});
        int c = new A1010PairsSongsWithTotalDurationsDivisibleby60().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

//    Input: time = [30,20,150,100,40,60,60]
//    Input: time = [30,20,30,40,40,0,0]
//    0 1 2 3 4
//    0 1
//    0 1 3 6 10
}
