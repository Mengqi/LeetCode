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
    public ListNode partition(ListNode head, int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        ListNode lessHead = null;
        ListNode lessNode = null;
        ListNode prevNode = head;
        ListNode currNode = head;
        while (currNode != null) {
            if (currNode.val < x) {
                // remove node from head list
                if (currNode == head) {
                    head = currNode.next;
                    prevNode = head;
                    currNode.next = null;
                } else {
                    prevNode.next = currNode.next;
                    currNode.next = null;
                }

                // add it to lessHead
                if (lessHead == null) {
                    lessHead = currNode;
                    lessNode = currNode;
                } else {
                    lessNode.next = currNode;
                    lessNode = currNode;
                }

                // traverse to next node
                if (prevNode == head) {
                    currNode = head;
                } else {
                    currNode = prevNode.next;
                }
            } else {
                prevNode = currNode;
                currNode = currNode.next;
            }
        }

        if (lessHead != null) {
            lessNode.next = head;
            return lessHead;
        } else {
            return head;
        }
    }
}
