import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A1086HighFive {
    public int[][] highFive(int[][] items) {

        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {//如果要正序，o1比o2大返回1
                int d = o1[0] - o2[0];
                if (d > 0) {
                    return 1;
                } else if (d < 0) {
                    return -1;
                } else {
                    return o1[1] > o2[1] ? -1 : 1;
                }
            }
        });

        List<int[]> list = new ArrayList<>();
        int preId=0;
        for (int i = 0; i < items.length; i++) {
            if(items[i][0] != preId){
                list.add(new int[]{items[i][0],(items[i][1]+items[i+1][1]+items[i+2][1]+items[i+3][1]+items[i+4][1])/5});
                preId=items[i][0];
            }
        }
        //list.toArray 带Type的正确用法
        int[][] type = new int[][]{};
        return list.toArray(type);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new A1086HighFive().highFive(new int[][]{{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}})));
    }
}
