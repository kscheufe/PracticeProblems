/*
Given two integer arrays preorder and inorder where preorder is the 
preorder traversal of a binary tree and inorder is the inorder traversal 
of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1) return new TreeNode(preorder[0]);//handle base case of 1 element
        if (preorder.length == 0) return null;//handle base case of 0 element
        TreeNode root = new TreeNode(preorder[0]);
        int rightSize = 0;
        int leftSize;
        for (leftSize = 0; leftSize < preorder.length; leftSize++)
        {
            if (inorder[leftSize] == root.val)
            {
                rightSize = preorder.length-1-leftSize;//1 for the root
                break;
            }
        }
        int[] leftInorderArray = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] rightInorderArray = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        int[] leftPreorderArray = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] rightPreorderArray = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
        root.left = buildTree(leftPreorderArray, leftInorderArray);
        root.right = buildTree(rightPreorderArray, rightInorderArray);
        return root;
    }
}