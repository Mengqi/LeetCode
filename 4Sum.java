public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();

        int length = num.length;
        if (length < 4) {
            return solutions;
        }

        Arrays.sort(num);
        for (int i = 0; i < length - 3; i++) {
            for (int j = length-1; j > i+2; j--) {
                int sum2 = num[i] + num[j];
                int aim = target - sum2;
                int start = i+1;
                int end = j-1;
                while (start < end) {
                    if (num[start] + num[end] == aim) {
                        ArrayList<Integer> sln = new ArrayList<Integer>();
                        sln.add(num[i]);
                        sln.add(num[start]);
                        sln.add(num[end]);
                        sln.add(num[j]);
                        if (!solutions.contains(sln)) {
                            solutions.add(sln);
                        }
                        start++;
                        end--;
                    } else if (num[start] + num[end] < aim) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return solutions;
    }
}
