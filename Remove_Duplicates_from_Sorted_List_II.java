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
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        if (head == null) {
            return null;
        }
        
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (currNode.val == nextNode.val) {
                while ((nextNode != null) && (currNode.val == nextNode.val)) {
                    nextNode = nextNode.next;
                }
                if (prevNode != null) {
                    prevNode.next = nextNode;
                } else {
                    head = nextNode;
                }
                currNode = nextNode;
                if (currNode != null) {
                    nextNode = currNode.next;
                } else {
                    nextNode = null;
                }
            } else {
                prevNode = currNode;
                currNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        return head;
    }
}