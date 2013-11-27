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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head.next;
        }

        int length = getLength(head);
        int pos = length - n;
        
        ListNode prevNode = head;
        ListNode currNode = head;
        int count = 0;
        while ((currNode != null) && (count < pos)) {
            prevNode = currNode;
            currNode = currNode.next;
            count++;
        }
        
        if (currNode != prevNode) {
            prevNode.next= currNode.next;
        } else {
            head = currNode.next;
        }
        return head;
    }
    
    private int getLength(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}

