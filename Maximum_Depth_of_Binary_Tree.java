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
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0);
    }
    
    private int getMaxDepth(TreeNode root, int prevDepth) {
        if (root == null) {
            return prevDepth;
        }
        int depth = prevDepth + 1;
        int depthLeft = getMaxDepth(root.left, depth);
        int depthRight = getMaxDepth(root.right, depth);
        
        if (depthLeft < depthRight) {
            return depthRight;
        } else {
            return depthLeft;
        }
    }
}