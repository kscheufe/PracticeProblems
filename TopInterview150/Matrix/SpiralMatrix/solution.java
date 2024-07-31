/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        int topIndex = 0;
        int rightIndex = matrix[0].length-1;
        int bottomIndex = matrix.length-1;
        int leftIndex = 0;
        int dirX = 1;
        int dirY = 0;
        int length = matrix[0].length*matrix.length;
        int posX = 0;
        int posY = 0;
        System.out.println(matrix[0][1]);

        for (int i = 0; i < length; i++)
        {
            output.add(matrix[posY][posX]);
            if (posX == rightIndex && dirX == 1) //top right
            {
                dirX = 0;
                dirY = 1;
                topIndex++;
            }
            else if (dirY == 1 && posY == bottomIndex) //bottom right
            {
                dirX = -1;
                dirY = 0;
                rightIndex--;
            }
            else if (posX == leftIndex && dirX == -1) //bottom left
            {
                dirX = 0;
                dirY = -1;
                bottomIndex--;
            }
            else if (dirY == -1 && posY == topIndex) //top left
            {
                dirX = 1;
                dirY = 0;
                leftIndex++;
            }
            posX += dirX;
            posY += dirY;
            System.out.println(posX + ", " + posY);
        }

        return output;
    }
}