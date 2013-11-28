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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> traverseList = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return traverseList;
        }

        // true: left->right; false: right->left
        boolean direction = true;
        Stack<TreeNode> stackPos = new Stack<TreeNode>();
        Stack<TreeNode> stackNeg = new Stack<TreeNode>();

        stackPos.push(root);
        while (!stackPos.isEmpty() || !stackNeg.isEmpty()) {
            ArrayList<Integer> traverse = new ArrayList<Integer>();
            if (direction == true) {
                while (!stackPos.isEmpty()) {
                    TreeNode node = stackPos.pop();
                    if (node.left != null) {
                        stackNeg.push(node.left);
                    }
                    if (node.right != null) {
                        stackNeg.push(node.right);
                    }
                    traverse.add(node.val);
                }
                traverseList.add(traverse);
                direction = false;
            } else {
                while (!stackNeg.isEmpty()) {
                    TreeNode node = stackNeg.pop();
                    if (node.right != null) {
                        stackPos.push(node.right);
                    }
                    if (node.left != null) {
                        stackPos.push(node.left);
                    }
                    traverse.add(node.val);
                }
                traverseList.add(traverse);
                direction = true;
            }
        }

        return traverseList;

    }
}
