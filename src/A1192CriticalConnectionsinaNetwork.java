import sun.security.x509.IPAddressName;

import java.util.*;
/*
 Tarjan算法：
 割边和割点的定义仅限于无向图中。我们可以通过定义以蛮力方式求解出无向图的所有割点和割边,但这样的求解方式效率低。
 Tarjan提出了一种快速求解的方式，通过一次DFS就求解出图中所有的割点和割边。
 自己按照教程写了代码https://www.cnblogs.com/nullzx/p/7968110.html
Runtime: 80 ms, faster than 94.21% of Java online submissions for Critical Connections in a Network.
Memory Usage: 96.7 MB, less than 100.00% of Java online submissions for Critical Connections in a Network.

*/
public class A1192CriticalConnectionsinaNetwork {
    ArrayList<Integer>[] map ;
    int maxdfn = 1;
    List<List<Integer>> r = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        map = new ArrayList[n];
        for (int i = 0; i < map.length; i++) {
            map[i]=new ArrayList<>();
        }
        for (int i = 0; i < connections.size(); i++) {
            int a =connections.get(i).get(0);
            int b =connections.get(i).get(1);
            map[a].add(b);
            map[b].add(a);
        }
        int[] dfn = new int[n];
        int[] low = new int[n];
        dfn[0] = 1;
        low[0] = 1;
        f(map[0], 0, null, dfn, low);
        return r;
    }

    private Integer f(List<Integer> list, int curNode, Integer preNode, int[] dfn, int[] low) {
        Integer minNextlow=Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int nextNode = list.get(i);
            if (preNode != null && nextNode == preNode) {
                continue;
            }
            if (dfn[nextNode] == 0) {
                dfn[nextNode] = ++maxdfn;
                low[nextNode] = maxdfn;
                Integer nextlow = f(map[nextNode], nextNode, curNode, dfn, low);
                if (nextlow != null) {
                    low[curNode] = Math.min(low[curNode], nextlow);
                }
                if(low[nextNode]>dfn[curNode]){
                    r.add(Arrays.asList(nextNode,curNode));
                }
            } else if (dfn[nextNode] != 0) {
                low[curNode] = Math.min(minNextlow,low[nextNode]);
                minNextlow = low[curNode];
            }
        }
        return low[curNode];
    }

    public static void main(String[] args) {
        A1192CriticalConnectionsinaNetwork.test2();
        A1192CriticalConnectionsinaNetwork.test1();
    }

    //  5
    //[[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]
    public static void test2() {
        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            input.add(new ArrayList<>());
        }
        input.get(0).add(1);
        input.get(0).add(0);
        input.get(1).add(2);
        input.get(1).add(0);
        input.get(2).add(3);
        input.get(2).add(2);
        input.get(3).add(4);
        input.get(3).add(2);
        input.get(4).add(4);
        input.get(4).add(3);
        input.get(5).add(3);
        input.get(5).add(0);
        input.get(6).add(4);
        input.get(6).add(0);
        List<List<Integer>> list = new A1192CriticalConnectionsinaNetwork().criticalConnections(5, input);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(0) + "," + list.get(i).get(1));
        }
        System.out.println("test2 end");
    }
    //  4          [[0,1],[1,2],[2,0],[1,3]]
    public static void test1() {
        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            input.add(new ArrayList<>());
        }
        input.get(0).add(0);
        input.get(0).add(1);
        input.get(1).add(1);
        input.get(1).add(2);
        input.get(2).add(2);
        input.get(2).add(0);
        input.get(3).add(1);
        input.get(3).add(3);
        List<List<Integer>> list = new A1192CriticalConnectionsinaNetwork().criticalConnections(4, input);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(0) + "," + list.get(i).get(1));
        }
        System.out.println("test1 end");
    }
}
