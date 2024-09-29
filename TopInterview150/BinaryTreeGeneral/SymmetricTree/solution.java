/*
Given the root of a binary tree, check whether it is a mirror of itself 
(i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        /* */
        if (isSameTree(invertTree(root.left), root.right))
        {
            return true;
        }
        return false;
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
        {
            return null;
        }
        else 
        {
            TreeNode temp = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(temp);
            return root;
        }        
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)//check for both non-existent
        {
            return true;
        }
        //check for different nodes
        if (p == null || q == null || p.val != q.val)
        {
            return false;
        }
        else //recursively check left == lfet and right ==right
        {
            return (true && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
    }
}