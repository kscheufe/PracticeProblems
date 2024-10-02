/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        
        connectNodes(root.left, root.right, root);
        return root;
    }

    public void connectNodes(Node left, Node right, Node parent) {
        if (left == null && right == null)
            return;//base case for recursion
        //connect left to right if both exist
        if (left != null && right != null)
            left.next = right;

        //if only one exists, or default to adding the right's next sibling
        if (left != null && right == null)
            left.next = getNext(parent);
        else
            right.next = getNext(parent);
            
        //recurse to the lower level
        //if (right != null)
            //connectNodes(right.left, right.right, right);
            connectNodes(right/*.left*/ != null ? right.left : null, right/*.right*/ != null ? right.right : null, right);
        //if (left != null)
            //connectNodes(left.left, left.right, left);
            connectNodes(left/*.left*/ != null ? left.left : null, left/*.right*/ != null ? left.right : null, left);
        
        
    }

    public Node getNext(Node node) {//takes in the parent of the node being search for
        while (node.next != null) {
            node = node.next;
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
        }
        return null;
    }
}
