public class A0122BestTimeBuySellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int a = prices[i + 1] - prices[i];
            sum += a > 0 ? a : 0;
        }
        return sum;
    }
}
