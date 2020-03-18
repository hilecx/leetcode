import java.util.*;

//讨论区的方法，没有验证过
public class A1192CriticalConnectionsinaNetwork2 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n], low = new int[n];
        // use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // build graph
        for (int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0), to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, graph, res, i);
            }
        }
        return res;
    }

    int time = 0; // time when discover each vertex

    private void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
        disc[u] = low[u] = ++time; // discover u
        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);
            if (v == pre) {
                continue; // if parent vertex, ignore
            }
            if (disc[v] == -1) { // if not discovered
                dfs(v, low, disc, graph, res, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    // u - v is critical, there is no path for v to reach back to u or previous vertices of u
                    res.add(Arrays.asList(u, v));
                }
            } else { // if v discovered and is not parent of u, update low[u], cannot use low[v] because u is not subtree of v
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        A1192CriticalConnectionsinaNetwork2.test2();
        A1192CriticalConnectionsinaNetwork2.test1();
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
        List<List<Integer>> list = new A1192CriticalConnectionsinaNetwork2().criticalConnections(5, input);
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
        List<List<Integer>> list = new A1192CriticalConnectionsinaNetwork2().criticalConnections(4, input);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(0) + "," + list.get(i).get(1));
        }
        System.out.println("test1 end");
    }
}
