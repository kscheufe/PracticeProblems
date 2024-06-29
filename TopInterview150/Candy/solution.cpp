class Solution {
public:
//one pass solution
    int candy(vector<int>& ratings) {
        if (ratings.size() == 0)
        {
            return 0;
        }
        int total = 1;
        int up = 0;
        int down = 0;
        int peak = 0;
        for (int i = 1; i <ratings.size(); i++)
        {
            if (ratings[i] > ratings[i-1])
            {
                up += 1;
                down = 0;
                peak = up;
                total += up +1;
            }
            else if (ratings[i] < ratings[i-1])
            {
                up = 0;
                down += 1;
                total += down;
                if (peak < down)
                {
                    total += 1;
                }
            }
            else
            {
                up = 0; down = 0; peak = 0;
                total += 1;
            }
        }
        return total;
    }
};