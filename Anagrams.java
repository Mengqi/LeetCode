public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> solution = new ArrayList<String>();
        HashMap<String, ArrayList<String>> anaMap = new HashMap<String, ArrayList<String>>();

        for (String word : strs) {
            String key = sortString(word);
            if (!anaMap.containsKey(key)) {
                ArrayList<String> wordList = new ArrayList<String>();
                wordList.add(word);
                anaMap.put(key, wordList);
            } else {
                ArrayList<String> wordList = anaMap.get(key);
                wordList.add(word);
            }
        }

        for (String key : anaMap.keySet()) {
            ArrayList<String> wordList = anaMap.get(key);
            if (wordList.size() >= 2) {
                solution.addAll(wordList);
            }
        }

        return solution;
    }

    private String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }
}
