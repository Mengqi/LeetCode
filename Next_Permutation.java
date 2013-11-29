public class Solution {
    public void nextPermutation(int[] num) {
        if ((num == null) || (num.length < 2)) {
            return;
        }


        for (int i = num.length-1; i > 0; i--) {
            if (num[i] > num[i-1]) {
                int minPos = getMinPos(num[i-1], num, i);
                swap(num, i-1, minPos);
                Arrays.sort(num, i, num.length);
                return;
            }
        }

        // edge case, need to reverse the array
        reverse(num);
    }

    // get the position of minimum number among all numbers > n in num[pos...length-1]
    private int getMinPos(int n, int [] num, int pos) {
        int min = num[pos];
        int minPos = pos;
        int i = pos+1;
        while (i < num.length) {
            if ((num[i] > n) && (num[i] < min)) {
                min = num[i];
                minPos = i;
            }
            i++;
        }
        return minPos;
    }

    private void swap(int[] num, int p1, int p2) {
        int temp = num[p1];
        num[p1] = num[p2];
        num[p2] = temp;
    }

    private void reverse(int [] num) {
        int start = 0;
        int end = num.length-1;
        while (start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }
}
