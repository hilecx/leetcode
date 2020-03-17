public class A0256PaintHouse2 {

    public int minCost2(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int dp0 =0;
        int dp1=0;
        int dp2 =0;
        for (int i = 0; i < costs.length; i++) {
            int cost0 = costs[i][0] + dp0;
            int cost1 = costs[i][1] + dp1;
            int cost2 = costs[i][2] + dp2;
            dp0 = Math.min(cost1,cost2);
            dp1 = Math.min(cost0,cost2);
            dp2 = Math.min(cost0,cost1);
        }

        return Math.min(dp0,Math.min(dp1,dp2));
    }

    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length][3];//[house index][color]
        dp[0][0] = Math.min(costs[0][1], costs[0][2]);
        dp[0][1] = Math.min(costs[0][0], costs[0][2]);
        dp[0][2] = Math.min(costs[0][0], costs[0][1]);
        for (int i = 1; i < costs.length; i++) {
            int cost0 = costs[i][0] + dp[i - 1][0];
            int cost1 = costs[i][1] + dp[i - 1][1];
            int cost2 = costs[i][2] + dp[i - 1][2];
            dp[i][0] = Math.min(cost1,cost2);
            dp[i][1] = Math.min(cost0,cost2);
            dp[i][2] = Math.min(cost0,cost1);
        }

        return min3(dp[costs.length - 1][0], dp[costs.length - 1][1], dp[costs.length - 1][2]);
    }

//    private int find(int houseIndex, int color) {
//
//
//    }

    private int min3(int a, int b, int c) {
        int t = Math.min(a, b);
        return Math.min(t, c);
    }

    public static void main(String[] args) {
        System.out.println(new A0256PaintHouse2().minCost(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        System.out.println(new A0256PaintHouse2().minCost(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}}));
        System.out.println(new A0256PaintHouse2().minCost(new int[][]{{3, 5, 3}, {6, 17, 6}, {7, 13, 18}, {9, 10, 18}}));
    }
}
