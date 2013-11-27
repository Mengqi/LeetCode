/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return paths;
        }
        
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        return getPath(root, prefix, sum);
    }
    
    private ArrayList<ArrayList<Integer>> getPath(TreeNode root, ArrayList<Integer> prefix, int sum) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return paths;
        }
        
        if ((root.left == null) && (root.right == null)) {
            if (sum == root.val) {
                ArrayList<Integer> path = new ArrayList<Integer>(prefix);
                path.add(sum);
                paths.add(path);
            }
            return paths;
        }
        
        if (root.left != null) {
            ArrayList<Integer> newPrefix = new ArrayList<Integer>(prefix);
            newPrefix.add(root.val);
            ArrayList<ArrayList<Integer>> pLeft = getPath(root.left, newPrefix, sum-root.val);
            paths.addAll(pLeft);
        }
        
        if (root.right != null) {
            ArrayList<Integer> newPrefix = new ArrayList<Integer>(prefix);
            newPrefix.add(root.val);
            ArrayList<ArrayList<Integer>> pRight = getPath(root.right, newPrefix, sum-root.val);
            paths.addAll(pRight);
        }

        return paths;
    }
}