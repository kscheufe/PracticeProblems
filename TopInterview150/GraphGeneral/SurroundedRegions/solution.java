/*
You are given an m x n matrix board containing letters 'X' and 'O', 
capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the 
region with 'X' cells and none of the region cells are on the edge of the 
board.
A surrounded region is captured by replacing all 'O's with 'X's in the 
input matrix board.

Example 1:
Input: board = [
["X","X","X","X"],
["X","O","O","X"],
["X","X","O","X"],
["X","O","X","X"]]

Output: [
["X","X","X","X"],
["X","X","X","X"],
["X","X","X","X"],
["X","O","X","X"]]

Explanation:
In the above diagram, the bottom region is not captured because it is on 
the edge of the board and cannot be surrounded.

Example 2:
Input: board = [["X"]]
Output: [["X"]]

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
 */
class Solution {
    public void solve(char[][] board) {
        //go around perimeter, mark O as S for safe for now
        int i = 0; int j = 0;
        //each time you find an O, check it's neighbours for more Os and 
        //mark them as safe (same traversal function as last time)
        while (i < board.length)
        {
            if (board[i][j] == 'O')
            {
                board[i][j] = 'S';
                traverseNeighbours(i, j, board, 'O', 'S');
            }
            i++;
        }
        i--;
        while (j < board[0].length)
        {
            if (board[i][j] == 'O')
            {
                board[i][j] = 'S';
                traverseNeighbours(i, j, board, 'O', 'S');
            }
            j++;
        }
        j--;
        while (i >= 0)
        {
            if (board[i][j] == 'O')
            {
                board[i][j] = 'S';
                traverseNeighbours(i, j, board, 'O', 'S');
            }
            i--;
        }
        i++;
        while (j >= 0)
        {
            if (board[i][j] == 'O')
            {
                board[i][j] = 'S';
                traverseNeighbours(i, j, board, 'O', 'S');
            }
            j--;
        }
        j++;
        //mark every remaining O as X and S and O
        for (i = 0; i < board.length; i++)
        {
            for (j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }

    public char[][] traverseNeighbours(int i, int j, char[][] grid, char targetChar, char replacementChar)
    {
        if (i != 0 && grid[i-1][j] == targetChar)//left
        {
            grid[i-1][j] = replacementChar;//mark visited
            traverseNeighbours(i-1, j, grid, targetChar, replacementChar);//check neighbours
        }
        if (i != grid.length-1 && grid[i+1][j] == targetChar)//right
        {
            grid[i+1][j] = replacementChar;
            traverseNeighbours(i+1, j, grid, targetChar, replacementChar);
        }
        if (j != grid[0].length-1 && grid[i][j+1] == targetChar)//bottom
        {
            grid[i][j+1] = replacementChar;
            traverseNeighbours(i, j+1, grid, targetChar, replacementChar);
        }
        if (j != 0 && grid[i][j-1] == targetChar)//top
        {
            grid[i][j-1] = replacementChar;
            traverseNeighbours(i, j-1, grid, targetChar, replacementChar);
        }
        
        return grid;
    }
}