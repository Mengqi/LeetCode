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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return levels;
        }
        
        Queue<TreeNode> currQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
        
        currQueue.add(root);
        ArrayList<Integer> currLevel = new ArrayList<Integer>();
        while (!currQueue.isEmpty()) {
            TreeNode node = currQueue.remove();
            currLevel.add(node.val);
            if (node.left != null) {
                nextQueue.add(node.left);
            }
            if (node.right != null) {
                nextQueue.add(node.right);
            }
            
            if (currQueue.isEmpty()) {
                levels.add(0,currLevel);
                currLevel = new ArrayList<Integer>();
                Queue<TreeNode> tmp = currQueue;
                currQueue = nextQueue;
                nextQueue = tmp;
            }
        }
        
        return levels;
    }
}