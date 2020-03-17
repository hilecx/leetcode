public class A0256PaintHouse {
    int minCost = 0;
    Integer[][] dp;
    int[][] c;
    public int minCost(int[][] costs) {
        if(costs.length==0){
            return 0;
        }
        c = costs;
        dp = new Integer[costs.length+1][3];//[house index][color]
        minCost = min3(find(0,0),find(0,1),find(0,2));
        return minCost;
    }

    private int find(int houseIndex, int color){
        if(houseIndex==c.length){
            return 0;
        }
        if(dp[houseIndex][color]!=null){
            return dp[houseIndex][color];
        }

        Integer prev = null;
        for (int i = 0; i < 3; i++) {
            if(i!=color){
                int r = c[houseIndex][i]+find(houseIndex+1,i);
                dp[houseIndex][i]=r;
                if(prev==null){
                    prev=r;
                }else{
                    return Math.min(r,prev);
                }
            }
        }

        return 0;
    }

    private int min3(int a,int b,int c){
        int t = Math.min(a,b);
        return Math.min(t,c);
    }

    public static void main(String[] args) {
        System.out.println(new A0256PaintHouse().minCost(new int[][]{{1,2,3},{4,5,6}}));
        System.out.println(new A0256PaintHouse().minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
        System.out.println(new A0256PaintHouse().minCost(new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}}));
    }
}
