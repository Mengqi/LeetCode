public class Solution {
    public int longestConsecutive(int[] num) {
        if ((num == null) || (num.length == 0)) {
            return 0;
        }

        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            numMap.put(num[i], 0);
        }
        int start;
        int end;
        int length;
        int maxLength = 1;
        for (int i = 1; i < num.length; i++) {
            int flag = numMap.get(num[i]);
            if (flag == 0) {    // have not visited yet
                start = num[i];
                end = num[i];
                length = 1;
                boolean startFlag = numMap.containsKey(start-1);
                boolean endFlag = numMap.containsKey(end+1);
                while (startFlag || endFlag) {
                    if (startFlag) {
                        start = start - 1;
                        numMap.put(start, 1);
                        length++;
                    }
                    if (endFlag) {
                        end = end + 1;
                        numMap.put(end, 1);
                        length++;
                    }
                    if (maxLength < length) {
                        maxLength = length;
                    }
                    startFlag = numMap.containsKey(start-1);
                    endFlag = numMap.containsKey(end+1);
                }
            }
        }
        return maxLength;
    }
}