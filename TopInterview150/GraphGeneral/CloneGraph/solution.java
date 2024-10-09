/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of 
its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
 

Test case format:

For simplicity, each node's value is the same as the node's index 
(1-indexed). For example, the first node with val == 1, the second node 
with val == 2, and so on. The graph is represented in the test case using 
an adjacency list.

An adjacency list is a collection of unordered lists used to represent a 
finite graph. Each list describes the set of neighbors of a node in the 
graph.

The given node will always be the first node with val = 1. You must 
return the copy of the given node as a reference to the cloned graph. 

Example 1:
Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node 
(val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node 
(val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node 
(val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node 
(val = 3).

Example 2:
Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph 
consists of only one node with val = 1 and it does not have any neighbors.

Example 3:
Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.
 

Constraints:

The number of nodes in the graph is in the range [0, 100].
1 <= Node.val <= 100
Node.val is unique for each node.
There are no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node newNode = new Node(node.val);
        if (node.neighbors.size() == 0) return newNode;
        //create neighbors and connections
        HashMap<Integer, Node> newNodes = new HashMap<>();
        Stack<Node> oldNodesStack = new Stack<>();//DFS
        Set<Integer> processedNodeIDs = new HashSet<>();

        //add head node to stack
        oldNodesStack.push(node);
        //push head node to hmap
        newNodes.put(newNode.val, newNode);

        while (!oldNodesStack.isEmpty())
        {
            Node old = oldNodesStack.pop();
            List<Node> oldNeighbors = old.neighbors;//ArrayList of Nodes

            //fetch the duplicate of the new node to populate it's list
            Node duplicate = newNodes.get(old.val);
            ArrayList<Node> newNeighbors = new ArrayList<>();
            
            for (Node temp : oldNeighbors)//for each neighbor of old
            {
                Node newN = newNodes.get(temp.val);//get new Node from hMap
                if (newN == null) newN = new Node(temp.val);
                //need to get from hmap first to add correct pointers

                //add all newN connections to current
                newNeighbors.add(newN);
                //i need to add newN to the hashMap to be able to pull it and 
                //set it's neighbors later
                newNodes.put(newN.val, newN);

                //push unprocessed nodes to stack
                if (!processedNodeIDs.contains(newN.val))
                {
                    oldNodesStack.push(temp);
                }

            }
            
            duplicate.neighbors = newNeighbors;
            newNodes.put(duplicate.val, duplicate);//add completed node to hashmap for checking
            processedNodeIDs.add(duplicate.val);
        }
        //get neighbours of current
        //for each neighbour, check if it exists:
            //if not, instantiate it and create the connection
            //if yes, create the connection

        return newNode;
    }
}