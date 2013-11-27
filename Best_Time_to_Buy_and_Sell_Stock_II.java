public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int currPrice = prices[i];
            int nextPrice = prices[i+1];
            if (nextPrice - currPrice > 0) {
                profit = profit + nextPrice - currPrice;
            }
        }
        
        return profit;
    }
}

