public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] pair = new int[2];
        int length = numbers.length;

        // map number to its index
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < length; i++) {
            if (!indexMap.containsKey(numbers[i])) {
                indexMap.put(numbers[i], i);
            } else {
                if (target == numbers[i] * 2) {
                    pair[0] = indexMap.get(numbers[i]) + 1;
                    pair[1] = i + 1;
                    return pair;
                }
            }
        }

        for(int i = 0; i < length; i++) {
            int remainder = target - numbers[i];
            if (indexMap.containsKey(remainder) && indexMap.get(remainder) != i) {
                pair[0] = i + 1;
                pair[1] = indexMap.get(remainder) + 1;
                break;
            }
        }
        return pair;
    }
}
