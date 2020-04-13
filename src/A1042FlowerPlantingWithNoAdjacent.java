import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A1042FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int N, int[][] paths) {
        List[] lists = new List[N];
        Arrays.fill(lists,new ArrayList<>());
        for (int i = 0; i < paths.length; i++) {
            lists[paths[i][0]-1].add(paths[i][1]);
            lists[paths[i][1]-1].add(paths[i][0]);
        }
        return null;
    }
}
