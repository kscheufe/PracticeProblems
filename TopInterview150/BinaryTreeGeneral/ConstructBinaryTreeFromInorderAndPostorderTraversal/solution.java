/*
Given two integer arrays inorder and postorder where inorder is the 
inorder traversal of a binary tree and postorder is the postorder 
traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
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
//inorder gives size of branches
//postorder gives root, not exactly the same as before, but quite similar
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        if (postorder.length == 1) return new TreeNode(postorder[0]);//just for mental comprehension of end of array, same as [0]
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int i = 0;//length of left section
        for (i = 0; i < postorder.length; i++)
        {
            if (inorder[i] == root.val)
            {
                break;
            }
        }
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, i);
        int[] rightInorder = Arrays.copyOfRange(inorder, i+1, postorder.length);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, i);
        int[] rightPostorder = Arrays.copyOfRange(postorder, i, postorder.length-1);
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }
}