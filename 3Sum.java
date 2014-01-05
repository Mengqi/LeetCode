public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<ArrayList<Integer>>();
        
        if (num.length < 3) {
            return solutions;
        }
        
        Arrays.sort(num);
        
        for (int i = 0; i <= num.length - 3; i++) {
            if (i != 0 && num[i] == num[i-1]) {
                continue;
            }
            
            int target = 0 - num[i];
            if (target < num[i]*2) {
                break;
            }
            
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[start] + num[end];
                if (sum == target) {
                    ArrayList<Integer> sln = new ArrayList<Integer>();
                    sln.add(num[i]);
                    sln.add(num[start]);
                    sln.add(num[end]);
                    solutions.add(sln);
                    start++;
                    end--;
                    while (start < end && num[start] == num[start-1]) {
                        start++;
                    }
                    while (start < end && num[end] == num[end+1]) {
                        end--;
                    }
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        
        return solutions;
    }
}
