public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if ((triangle == null) || (triangle.size() == 0)) {
            return 0;
        }

        int size = triangle.size();
        ArrayList<Integer> prevList = triangle.get(size-1);
        ArrayList<Integer> currList = triangle.get(size-1);
        for (int i = size - 2; i >=0; i--) {
            prevList = currList;
            currList = new ArrayList<Integer>(triangle.get(i));
            for (int j = 0; j < currList.size(); j++) {
                int cost0 = currList.get(j) + prevList.get(j);
                int cost1 = currList.get(j) + prevList.get(j+1);
                if (cost0 < cost1) {
                    currList.set(j, cost0);
                } else {
                    currList.set(j, cost1);
                }
            }
        }
        return currList.get(0);
    }
}
