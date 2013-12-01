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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        if (m >= n) {
            return head;
        }

        ListNode currNode = head;
        ListNode prevNode = head;
        int pos = 1;
        while (pos < m) {
            prevNode = currNode;
            currNode = currNode.next;
            pos++;
        }
        ListNode nodeLow = prevNode;
        ListNode nodeHigh = currNode;


        ListNode revHead = null;
        ListNode nextNode = currNode.next;
        while (pos <= n) {
            currNode.next = revHead;
            revHead = currNode;
            currNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
            pos++;
        }

        if (m == 1) {
            head = revHead;
            nodeHigh.next = currNode;
        } else {
            nodeLow.next = revHead;
            nodeHigh.next = currNode;
        }
        return head;
    }
