public class LRUCache {
    private int capacity;
    private int count;
    
    private CacheNode head;
    private CacheNode tail;
    private Map<Integer, CacheNode> cacheMap;
    
    private class CacheNode {
        int key;
        int val;
        CacheNode next;
        CacheNode prev;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        cacheMap = new HashMap<Integer, CacheNode>();
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        CacheNode node = getNode(key);
        
        if (node == null) {
            return -1;
        } else {
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        
        // found the node
        CacheNode node = getNode(key);
        if (node != null) {
            node.val = value;
        } else {    // node not found
            // over-capacity, remove the last one
            if (count == capacity) {
                count--;
                // capacity == 1
                if (capacity == 1) {
                    cacheMap.put(tail.key, null);
                    head = null;
                    tail = null;
                } else {
                    cacheMap.put(tail.key, null);
                    CacheNode secondLastNode = tail.prev;
                    secondLastNode.next = null;
                    tail = secondLastNode;
                }
            }
            
            // add new node to the head
            CacheNode newNode = new CacheNode();
            newNode.key = key;
            newNode.val = value;
            newNode.next = head;
            if (head == null) {
                tail = newNode;
            } else {
                head.prev = newNode;
            }
            newNode.prev = null;
            head = newNode;
            cacheMap.put(key, newNode);
            count++;
        }
    }

    private CacheNode getNode(int key) {
        CacheNode node = cacheMap.get(key);
        
        if (node != null) {
            if (node != head) {
                CacheNode prevNode = node.prev;
                CacheNode nextNode = node.next;
                
                prevNode.next = nextNode;
                if (nextNode != null) { // not tail
                    nextNode.prev = prevNode;
                } else { // tail
                    tail = prevNode;
                }
                node.next = head;
                head.prev = node;
                node.prev = null;
                head = node;
            }
        }

        return node;
    }
}
