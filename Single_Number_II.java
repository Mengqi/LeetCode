public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                countMap.put(num, count+1);
            } else {
                countMap.put(num, 1);
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}

