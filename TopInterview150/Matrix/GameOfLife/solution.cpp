class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        for (int i = 0; i < board.size(); i++)
        {
            for (int j = 0; j < board[0].size(); j++)
            {
                //check the 8 positions
                if (i != 0)
                {
                    if (board[i-1][j]%10 == 1)
                    {
                        board[i][j] += 10;
                    }
                    if (j != 0 && board[i-1][j-1] %10 == 1)
                    {
                        board[i][j]+= 10;
                    }
                    if (j != board[0].size()-1 && board[i-1][j+1] %10 == 1)
                    {
                        board[i][j]+= 10;
                    }
                }
                if (j != 0 && board[i][j-1] %10 == 1)
                {
                    board[i][j] +=10;
                }
                if (j != board[0].size()-1 && board[i][j+1] %10 == 1)
                {
                    board[i][j] +=10;
                }
                if (i != board.size()-1)
                {
                    if (board[i+1][j] % 10 == 1)
                    {
                        board[i][j] +=10;
                    }
                    if (j != 0 && board[i+1][j-1] %10 == 1)
                    {
                        board[i][j]+= 10;
                    }
                    if (j != board[0].size()-1 && board[i+1][j+1] %10 == 1)
                    {
                        board[i][j]+= 10;
                    }
                }
            }
        }
        for (int i = 0; i < board.size(); i++)
        {
            for (int j = 0; j < board[0].size(); j++)
            {
                if (board[i][j] < 32 && board[i][j] > 20)
                {
                    board[i][j] = 1;
                }
                else
                    board[i][j] = 0;
            }
        }
    }
};