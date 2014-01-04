public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] pair = new int [2];
        int length = numbers.length;
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < length; i++) {
            if (!numMap.containsKey(numbers[i])) {
                numMap.put(numbers[i], i);
            } else {
                if (target == numbers[i] * 2) {
                    pair[0] = numMap.get(numbers[i]) + 1;
                    pair[1] = i + 1;
                    return pair;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            int num = numbers[i];
            int remainder = target - num;
            if (numMap.containsKey(remainder)) {
                int rIndex = numMap.get(remainder);
                if (i < rIndex) {
                    pair[0] = i + 1;
                    pair[1] = rIndex + 1;
                } else {
                    pair[0] = rIndex + 1;
                    pair[1] = i + 1;
                }
                break;
            }
        }
        return pair;
    }
}
