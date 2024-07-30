class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        set<int> Set;

        //check rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                {
                    if (Set.find(board[i][j]) != Set.end())
                        return false;
                    Set.insert(board[i][j]);
                }
            }
            Set.clear();
        }
        //check columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.')
                {
                    if (Set.find(board[j][i]) != Set.end())
                        return false;
                    Set.insert(board[j][i]);
                }
            }
            Set.clear();
        }

        //check boxes
        for (int k = 0; k < 9; k++)
        {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i + 3 * (k%3)][j + 3 * (k/3)] != '.')
                    {
                        if (Set.find(board[i + 3 * (k%3)][j + 3 * (k/3)]) != Set.end())
                            return false;
                        Set.insert(board[i + 3 * (k%3)][j + 3 * (k/3)]);
                    }
                }
            }
            Set.clear();
        }
        return true;
    }
};
