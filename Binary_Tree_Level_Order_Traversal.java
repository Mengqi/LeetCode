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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return levels;
        }
        
        Queue<TreeNode> currQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
        
        currQueue.add(root);
        ArrayList<Integer> currentLevel = new ArrayList<Integer>();
        while(!currQueue.isEmpty()) {
            TreeNode node = currQueue.remove();
            currentLevel.add(0, node.val);
            if (node.right != null) {
                nextQueue.add(node.right);
            }
            if (node.left != null) {
                nextQueue.add(node.left);
            }
            if (currQueue.isEmpty()) {
                currQueue = nextQueue;
                nextQueue = new LinkedList<TreeNode>();
                levels.add(currentLevel);
                currentLevel = new ArrayList<Integer>();
            }
        }
        return levels;
    }
}
