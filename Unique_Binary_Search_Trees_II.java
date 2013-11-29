/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return getTrees(1, n);
    }

    private ArrayList<TreeNode> getTrees(int start, int end) {
        ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
        if (start > end) {
            trees.add(null);
            return trees;
        } else if (start == end) {
            TreeNode node = new TreeNode(start);
            node.left = null;
            node.right = null;
            trees.add(node);
            return trees;
        }

        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftTrees = getTrees(start, i-1);
            ArrayList<TreeNode> rightTrees = getTrees(i+1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    trees.add(node);
                }
            }
        }
        return trees;
    }
}
