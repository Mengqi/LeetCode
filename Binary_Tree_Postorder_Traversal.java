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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        if (root == null) {
            return arr;
        }
        
        Stack<TreeNode> treeStack = new Stack<TreeNode>();
        treeStack.push(root);
        
        while (!treeStack.empty()) {
            TreeNode node = treeStack.pop();
            int val = node.val;
            arr.add(0, val);
            
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                treeStack.add(left);
            }
            if (right != null) {
                treeStack.add(right);
            }
        }
        return arr;
    }
}