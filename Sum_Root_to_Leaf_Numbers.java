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
    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
    }
    
    private int getSum(TreeNode root, int prefix) {
        if (root == null) {
            return 0;
        }
        
        prefix = prefix * 10 + root.val;
        if (root.left == null && root.right == null) {
            return prefix;
        } else {
            return getSum(root.left, prefix) + getSum(root.right, prefix);
        }
    }
    
}
