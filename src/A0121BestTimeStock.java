public class A0121BestTimeStock {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int lowest = prices[0];
        int maxProfit = 0;
        int currentProfit;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>lowest){
                currentProfit = prices[i]-lowest;
            }else {
                lowest = prices[i];
                currentProfit = 0;
            }
            maxProfit = Math.max(maxProfit,currentProfit);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int r = new A0121BestTimeStock().maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(r);
        int r2 = new A0121BestTimeStock().maxProfit(new int[]{7,6,4,3,1});
        System.out.println(r2);
    }
}
