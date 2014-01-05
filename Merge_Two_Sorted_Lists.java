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
        ListNode head = null;
        ListNode prev = null;
        ListNode node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
                node.next = null;
            } else {
                node = l2;
                l2 = l2.next;
                node.next = null;
            }
            
            if (head == null) {
                head = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }
        }
        
        if (l1 != null) {
            if (head == null) {
                head = l1;
            } else {
                prev.next = l1;
            }
        }
        
        if (l2 != null) {
            if (head == null) {
                head = l2;
            } else {
                prev.next = l2;
            }
        }
        
        return head;
    }
}
