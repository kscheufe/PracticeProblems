/*
Given a binary tree, find the lowest common ancestor (LCA) of two given 
nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common 
ancestor is defined between two nodes p and q as the lowest node in T that 
has both p and q as descendants (where we allow a node to be a descendant 
of itself).”

 
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree
 *//**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        //check below first (work from bottom up)
        TreeNode tempR = lowestCommonAncestor(root.right, p, q);//take on pointer to p or q, or null
        TreeNode tempL = lowestCommonAncestor(root.left, p, q);
        //will be null if not found, or the node if found

        if (root == p) return p;//return p upwards
        if (root == q) return q;//return q upwards (to temp)

        /*this is lucky as well, if both are in the same path, it will be
        returning q, q, q, p, p for example, with p being higher in the
        tree. The temps will never both be true, and it will just return
        p all the way*/


        if (tempL != null && tempR != null)//found both below
            return root;
        if (tempL != null)//if only found one below, raise it upwards
            return tempL;
        if (tempR != null)
            return tempR;
        return null;//if nothing is found below and current is not one of them
    }
}    