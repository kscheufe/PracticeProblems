/*
Given the root of a Binary Search Tree (BST), return the minimum absolute 
difference between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
 *//**
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
    static int min;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        process(root);
        return min;
    }

    public void process(TreeNode root)
    {
        //need to check against rightmost child of left and 
        //leftmost child of right
        int currDiff = Math.min(
                Math.abs(root.val - getRightMost(root.left)), 
                Math.abs(root.val - getLeftMost(root.right))
            );
        min = Math.min(min, currDiff);

        //process children
        if (root.right != null) process(root.right);
        if (root.left != null) process(root.left);
    }

    public int getRightMost(TreeNode root)
    {
        if (root == null) return Integer.MAX_VALUE;//return astronomically large number, should maintain functionality within the specified 10^5 max limit for node val
        if (root.right == null) return root.val;
        return getRightMost(root.right);
    }

    public int getLeftMost(TreeNode root)
    {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null) return root.val;
        return getLeftMost(root.left);
    }
}