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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return getMinDepth(root, 0);
    }
    
    private int getMinDepth(TreeNode root, int depth) {
        if ((root.left == null) && (root.right == null)) {
            return depth + 1;
        }
        
        int leftDepth = -1;
        if (root.left != null) {
            leftDepth = getMinDepth(root.left, depth+1);
        }
        
        int rightDepth = -1;
        if (root.right != null) {
            rightDepth = getMinDepth(root.right, depth+1);
        }
        
        if (leftDepth == -1) {
            return rightDepth;
        } else if (rightDepth == -1) {
            return leftDepth;
        } else {
            if (leftDepth < rightDepth) {
                return leftDepth;
            } else {
                return rightDepth;
            }
        }
    }
}