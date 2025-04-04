/*
You are given an m x n integer matrix matrix with the following two 
properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the 
previous row.
Given an integer target, return true if target is in matrix or false 
otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int row = -1;

        while (left <= right)
        {
            int index = left + (right-left)/2;
            if (matrix[index][0] <= target && target <= matrix[index][matrix[index].length-1])
            {
                row = index;
                break;
            }

            else if (matrix[index][0] < target) left = index+1;
            else right = index -1;
        }

        if (row == -1) return false;
        left = 0;
        right = matrix[row].length-1;

        while (left <= right) {
            int index = left + (right - left)/2;

            if (matrix[row][index] == target) return true;
            else if (matrix[row][index] < target) left = index+1;
            else right = index - 1;
        }
        
        return false;

    }
}