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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        HashMap<TreeNode, Integer> maxPathSumMap = new HashMap<TreeNode, Integer>();
        maxPathSumMap.put(null, Integer.MIN_VALUE);
        HashMap<TreeNode, Integer> maxDepthSumMap = new HashMap<TreeNode, Integer>();
        maxDepthSumMap.put(null, Integer.MIN_VALUE);

        getMax(root, maxPathSumMap, maxDepthSumMap);

        return maxPathSumMap.get(root);
    }

    private void getMax(TreeNode root, HashMap<TreeNode, Integer> maxPathSumMap, HashMap<TreeNode, Integer>
    maxDepthSumMap) {
        if (root == null) {
            return;
        }

        getMax(root.left, maxPathSumMap, maxDepthSumMap);
        getMax(root.right, maxPathSumMap, maxDepthSumMap);

        int leftDepthSum = maxDepthSumMap.get(root.left);
        int rightDepthSum = maxDepthSumMap.get(root.right);

        int pathSum = root.val;
        if (leftDepthSum > 0) {
            pathSum = pathSum + leftDepthSum;
        }
        if (rightDepthSum > 0) {
            pathSum = pathSum + rightDepthSum;
        }

        int leftPathSum = maxPathSumMap.get(root.left);
        if (pathSum < leftPathSum) {
            pathSum = leftPathSum;
        }
        int rightPathSum = maxPathSumMap.get(root.right);
        if (pathSum < rightPathSum) {
            pathSum = rightPathSum;
        }
        maxPathSumMap.put(root, pathSum);

        int depthSum = root.val;
        if (leftDepthSum > rightDepthSum) {
            if (leftDepthSum > 0) {
                depthSum = depthSum + leftDepthSum;
            }
        } else {
            if (rightDepthSum > 0) {
                depthSum = depthSum + rightDepthSum;
            }
        }
        maxDepthSumMap.put(root, depthSum);
    }
}
