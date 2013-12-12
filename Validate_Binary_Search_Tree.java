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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        boolean leftResult = true;
        if (root.left != null) {
            int max = getRightMost(root.left);
            leftResult = max < root.val;
        }
        boolean rightResult = true;
        if (root.right != null) {
            int min = getLeftMost(root.right);
            rightResult = min > root.val;
        }
        
        return isValidBST(root.left) && isValidBST(root.right) && leftResult && rightResult;
    }
    
    private int getLeftMost(TreeNode root) {
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }
    
    private int getRightMost(TreeNode root) {
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }
}
