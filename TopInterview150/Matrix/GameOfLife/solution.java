/*
According to Wikipedia's article: "The Game of Life, also known simply as
Life, is a cellular automaton devised by the British mathematician John 
Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an 
initial state: live (represented by a 1) or dead (represented by a 0). 
Each cell interacts with its eight neighbors (horizontal, vertical, 
diagonal) using the following four rules (taken from the above Wikipedia 
article):

Any live cell with fewer than two live neighbors dies as if caused by 
under-population.
Any live cell with two or three live neighbors lives on to the next 
generation.
Any live cell with more than three live neighbors dies, as if by 
over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as 
if by reproduction.
The next state is created by applying the above rules simultaneously to 
every cell in the current state, where births and deaths occur 
simultaneously. Given the current state of the m x n grid board, return 
the next state.

Example 1:


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1
 */

 //could solve in place by multiplying to certain values (10, 20, 30)
 class Solution {
    public void gameOfLife(int[][] matrix) {//renamed because it's easier than rafactoring all matrix names after completing the algorithm
        //determine next value from neighbours
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                //up
                if (i != 0 && matrix[i-1][j]%10 == 1)//check position before it
                {
                    matrix[i][j]+= 10;
                }
                //left
                if (j != 0 && matrix[i][j-1]%10 == 1)//check position before it
                {
                    matrix[i][j]+= 10;
                }
                //down
                if (i != matrix.length-1 && matrix[i+1][j]%10 ==1)
                {
                    matrix[i][j] += 10;
                }
                //right
                if (j != matrix[0].length-1 && matrix[i][j+1]%10 ==1)
                {
                    matrix[i][j] += 10;
                }
                //upleft
                if (i != 0 && j != 0 && matrix[i-1][j-1]%10 == 1)//check position before it
                {
                    matrix[i][j]+= 10;
                }
                //upright
                if (i != 0 && j != matrix[0].length-1 && matrix[i-1][j+1]%10 == 1)//check position before it
                {
                    matrix[i][j]+= 10;
                }
                //downleft
                if (i != matrix.length-1 && j != 0 && matrix[i+1][j-1]%10 == 1)//check position before it
                {
                    matrix[i][j]+= 10;
                }
                //downright
                if (i != matrix.length-1 && j != matrix[0].length-1 && matrix[i+1][j+1]%10 == 1)//check position before it
                {
                    matrix[i][j]+= 10;
                }
            }
        }
        //update cell
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] < 21 || matrix[i][j] > 31)
                {
                    matrix[i][j] = 0;
                }
                else //21, 30, 31
                    matrix[i][j] = 1;
            }
        }
    }
}