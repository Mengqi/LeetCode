public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int [] maxProfit0 = new int [length];   // max profit from 0 to curr
        int [] maxProfit1 = new int [length];   // max profit from curr to length-1

        for (int i = 0; i < length; i++) {
            maxProfit0[i] = 0;
            maxProfit1[i] = 0;
        }

        int low = prices[0];
        int profit = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }

            if (prices[i] - low > profit) {
                profit = prices[i] - low;
            }
            maxProfit0[i] = profit;
        }

        int high = prices[length-1];
        profit = 0;
        for (int i = length-2; i >=0; i--) {
            if (prices[i] > high) {
                high = prices[i];
            }
            if (high - prices[i] > profit) {
                profit = high - prices[i];
            }
            maxProfit1[i] = profit;
        }

        profit = maxProfit0[0];
        for (int i = 0; i < length; i++) {
            int profit0 = maxProfit0[i];
            int profit1 = maxProfit1[i];
            if (profit0 + profit1 > profit) {
                profit = profit0 + profit1;
            }
        }
        return profit;
    }
}
