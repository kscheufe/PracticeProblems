/*

*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> newNodes = new HashMap<>();
        return clone(node, newNodes);
    }

    public Node clone(Node oldNode, Map<Integer, Node> newNodes) {
        if (newNodes.containsKey(oldNode.val))
        {
            return newNodes.get(oldNode.val);
        }

        Node newNode = new Node(oldNode.val);//create new node and 
        newNodes.put(oldNode.val, newNode);//add to map

        for (Node neighbor : oldNode.neighbors)
        {
            newNode.neighbors.add(clone(neighbor, newNodes));
        }

        return newNode;//sends map forward to create all nodes, recurses backwards to populate pointers from completed map
    }
}