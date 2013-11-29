public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> codes = new ArrayList<Integer>();
        codes.add(0);
        int chunk = 1;
        for (int i = 0; i < n; i++) {
            int size = codes.size();
            for (int j = size-1; j >=0; j--) {
                int prevCode = codes.get(j);
                int code = prevCode + chunk;
                codes.add(code);
            }
            chunk = chunk * 2;
        }
        return codes;
    }
}
