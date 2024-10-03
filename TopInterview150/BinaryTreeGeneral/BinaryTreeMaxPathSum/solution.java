/*
A path in a binary tree is a sequence of nodes where each pair of 
adjacent nodes in the sequence has an edge connecting them. A node can 
only appear in the sequence at most once. Note that the path does not 
need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any 
non-empty path.

 
Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a 
path sum of 2 + 1 + 3 = 6.

Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a 
path sum of 15 + 20 + 7 = 42.
 

Constraints:

The number of nodes in the tree is in the range [1, 3 * 10^4].
-1000 <= Node.val <= 1000
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
    static int highest;
    public int maxPathSum(TreeNode root)
    {
        highest = Integer.MIN_VALUE;//for multiple test cases
        int rootMax = solve(root);
        return highest;
    }
    public int solve(TreeNode root) {
        int leftMax = 0;
        int rightMax = 0;//can be 0 because they'll either be set or 
        highest = Math.max(highest, root.val);//check each node's root val
        if (root.right == null && root.left == null)
        {
            return root.val;
        }
        if (root.left != null)//left side
        {
            leftMax = Math.max(solve(root.left), 0);//only bother if left subtree is positive
        }
        if (root.right != null)//right side
        {
            rightMax = Math.max(solve(root.right), 0);//only bother if the right subtree has a positive value
        }
        highest = Math.max(highest, rightMax + leftMax + root.val);//case of both sides being positive
        //highest = Math.max(highest, rightMax + root.val);//case of left side of root being negative
        //highest = Math.max(highest, leftMax + root.val);//case of right side of root being negative
        return root.val + Math.max(rightMax, leftMax);//return value of current node + higher branch to current's parent

        //can visit at most 2 descendants per level of any node
        //if you go up a level from current root, you can only traverse one side of it's children (left or right)
        //basically return max(maxPathSum(left), maxPathSum(right))   at each node, also keeping track of a max static variable for highest possible max for paths that don't go through root (like example 2)
        //if at a leaf, just return leaf.val
    }
}