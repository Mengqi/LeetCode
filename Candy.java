public class Solution {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int [] candies = new int [length];

        for (int i = 0; i < length; i++) {
            candies[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i = length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candies[i] <= candies[i+1]) {
                candies[i] = candies[i+1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + candies[i];
        }

        return sum;
    }
}
