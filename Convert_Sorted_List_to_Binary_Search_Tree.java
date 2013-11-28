/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }

        return getTree(head, length);
    }

    private TreeNode getTree(ListNode head, int length) {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            TreeNode root = new TreeNode(head.val);
            root.left = null;
            root.right = null;
            return root;
        }

        // length >= 2
        int rootPos = length / 2;
        int pos = 0;
        ListNode node = head;
        while (pos < rootPos-1) {
            node = node.next;
            pos++;
        }

        ListNode left = head;
        ListNode rootNode = node.next;
        ListNode right = rootNode.next;
        rootNode.next = null;
        node.next = null;

        TreeNode root = new TreeNode(rootNode.val);
        TreeNode leftTree = getTree(left, pos+1);
        TreeNode rightTree = getTree(right, length - pos - 2);
        root.left = leftTree;
        root.right = rightTree;

        return root;
    }
}
