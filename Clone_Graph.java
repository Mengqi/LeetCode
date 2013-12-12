/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = bfsClone(node);
        for (UndirectedGraphNode gNode : nodeMap.keySet()) {
            UndirectedGraphNode cloneNode = nodeMap.get(gNode);
            for (UndirectedGraphNode neighborNode : gNode.neighbors) {
                UndirectedGraphNode cloneNeighbor = nodeMap.get(neighborNode);
                cloneNode.neighbors.add(cloneNeighbor);
            }
        }
        return nodeMap.get(node);
    }

    private HashMap<UndirectedGraphNode, UndirectedGraphNode> bfsClone(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode,
        UndirectedGraphNode>();
        Queue<UndirectedGraphNode> nodeQueue = new LinkedList<UndirectedGraphNode>();

        HashSet<UndirectedGraphNode> nodeSet = new HashSet<UndirectedGraphNode>();
        nodeQueue.add(node);
        while (!nodeQueue.isEmpty()) {
            UndirectedGraphNode gNode = nodeQueue.remove();
            nodeSet.add(gNode);
            UndirectedGraphNode cloneNode = new UndirectedGraphNode(gNode.label);
            nodeMap.put(gNode, cloneNode);
            for (UndirectedGraphNode neighborNode : gNode.neighbors) {
                if (!nodeSet.contains(neighborNode)) {
                    nodeQueue.add(neighborNode);
                }
            }
        }
        return nodeMap;
    }
}
