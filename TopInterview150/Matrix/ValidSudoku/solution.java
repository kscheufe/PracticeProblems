/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 */


 //would be faster to use a set, which i initially planned to do, but then chose not to
class Solution {
    public boolean isValidSudoku(char[][] board) {
        String rowNums = "";
        String colNums = "";
        String boxNums = "";
        for (int i = 0; i < board.length; i++)//rows
        {
            for (int j = 0; j < board.length; j++)
            {
                if (rowNums.contains(board[i][j] + ""))
                {
                    return false;
                }
                else if (board[i][j] != '.')
                    rowNums += board[i][j];
            }
            rowNums = "";
        }
        for (int i = 0; i < board.length; i++)//columns
        {
            for (int j = 0; j < board.length; j++)
            {
                if (colNums.contains(board[j][i] + ""))
                {
                    return false;
                }
                else if (board[j][i] != '.')
                    colNums += board[j][i];
            }
            colNums = "";
        }
        for (int k = 0; k < 9; k++)//boxes
        //when k%3 == 0, i is good
        //when k%3 == 1, add 3 to i
        //when k%3 == 2, add 6 to i
        //when k/3 == 0, j is good
        //when k/3 == 1, add 3 to j
        //when k/3 == 2, add 6 to j
        {
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (boxNums.contains(board[i + 3*(k%3)][j + 3*(k/3)] + ""))
                    {
                        return false;
                    }
                    else if (board[i + 3*(k%3)][j + 3*(k/3)] != '.')
                        boxNums += board[i + 3*(k%3)][j + 3*(k/3)];
                }
            }
            boxNums = "";
        }

        return true;
    }
}