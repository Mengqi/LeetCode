public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int low = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            if (prices[i] - low > profit) {
                profit = prices[i] - low;
            }
        }
        return profit;
    }
}