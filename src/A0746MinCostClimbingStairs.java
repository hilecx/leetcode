public class A0746MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if(cost==null || cost.length==0){
            return 0;
        }
        if(cost.length==1){
            return cost[0];
        }
        int dp1 = cost[0];
        int dp2 = cost[1];

        int mincost = dp2;
        for (int i = 2; i < cost.length; i++) {
            mincost = cost[i]+Math.min(dp1,dp2);
            dp1=dp2;
            dp2=mincost;
        }
        return Math.min(mincost,dp1);
    }
}
