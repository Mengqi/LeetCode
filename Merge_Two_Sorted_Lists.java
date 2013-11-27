/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        
        ListNode head = null;
        ListNode currNode = null;
        while ((node1 != null) && (node2 != null)) {
            ListNode node;
            if (node1.val < node2.val) {
                node = node1;
                node1 = node1.next;
                node.next = null;
            } else {
                node = node2;
                node2 = node2.next;
                node.next = null;
            }
            
            if (head == null) {
                head = node;
                currNode = node;
            } else {
                currNode.next = node;
                currNode = node;
            }
        }
        
        if (node1 != null) {
            if (head == null) {
                head = node1;
            } else {
                currNode.next = node1;
                currNode = node1;
            }
        } else {
            if (head == null) {
                head = node2;
            } else {
                currNode.next = node2;
                currNode = node2;
            }
        }
        
        return head;
    }
}