public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Character> digitList = new ArrayList<Character>();
        for (int i = 1; i <= n; i++) {
            char ch = (char) ('0' + i);
            digitList.add(ch);
        }

        String perm = "";
        int factorial = getFactorial(n);
        while (n > 0) {
            factorial = factorial / n;

            int index = (k-1) / factorial;
            char digit = digitList.get(index);
            digitList.remove(index);
            perm = perm + digit;

            k = k - index*factorial;
            n--;
        }
        return perm;
    }

    private int getFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
