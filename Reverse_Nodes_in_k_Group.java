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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        int length = getLength(head);
        if ((length <= 1) || (k > length)) {
            return head;
        }

        ListNode prevEnd = head;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        ListNode revHead;
        ListNode revEnd;
        int count;
        int leftNum = length;
        while (leftNum >= k) {
            revHead = null;
            revEnd = currNode;

            count = 1;
            while (count <= k) {
                currNode.next = revHead;
                revHead = currNode;

                currNode = nextNode;
                if (nextNode != null) {
                    nextNode = nextNode.next;
                }
                count++;
            }

            revEnd.next = currNode;
            if (prevEnd == head) {
                head = revHead;
                prevEnd = revEnd;
            } else {
                prevEnd.next = revHead;
                prevEnd = revEnd;
            }

            leftNum = leftNum - k;
        }
        return head;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
