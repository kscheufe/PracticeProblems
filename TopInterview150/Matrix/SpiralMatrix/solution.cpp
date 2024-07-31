class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> output;
        int top = 0;
        int left = 0;
        int bottom = matrix.size()-1;
        int right = matrix[0].size()-1;
        int dirX = 1;
        int dirY = 0;
        int posX = 0;
        int posY = 0;
        int num = (bottom +1)*(right+1);
        for (int i = 0; i < num; i++)
        {
            output.push_back(matrix[posY][posX]);
            if (dirX == 1 and posX == right)
            {
                dirX = 0;
                dirY = 1;
                top++;
            }
            else if (dirY == 1 and posY == bottom)
            {
                dirX = -1;
                dirY = 0;
                right--;
            }
            else if (dirX == -1 and posX == left)
            {
                dirX = 0;
                dirY = -1;
                bottom--;
            }
            else if (dirY == -1 && posY == top)
            {
                dirX = 1;
                dirY = 0;
                left++;
            }
            posX += dirX;
            posY += dirY;
        }


        return output;
    }
};