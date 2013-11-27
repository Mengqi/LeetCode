/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        HashMap<RandomListNode, RandomListNode> nodeMap = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode node = head;
        RandomListNode newHead = null;
        RandomListNode prevNode = null;
        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = null;
            if (prevNode == null) {
                newHead = newNode;
            } else {
                prevNode.next = newNode;
            }
            nodeMap.put(node, newNode);
            prevNode = newNode;
            node = node.next;
        }
        
        node = head;
        RandomListNode currNode = newHead;
        while (node != null) {
            RandomListNode randNode = node.random;
            RandomListNode newRandNode = nodeMap.get(randNode);
            currNode.random = newRandNode;
            node = node.next;
            currNode = currNode.next;
        }
        return newHead;
    }
}

