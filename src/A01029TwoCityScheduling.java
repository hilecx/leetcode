import java.util.Arrays;
import java.util.Comparator;

public class A01029TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {//如果要正序，o1比o2大返回1
                return (o1[0]-o1[1]) - (o2[0]-o2[1]);

            }
        });
        int sum = 0;
        for (int i = 0; i < costs.length/2; i++) {
            sum+=(costs[i][0]+costs[costs.length-i-1][1]);
        }
        return sum;
    }
}
