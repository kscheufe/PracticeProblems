class Solution {
public:
    string convert(string s, int numRows) {
        int dir = 1;
        int rowIndex = 0;
        vector<string> rows(numRows);

        if (numRows == 1 || numRows >= s.size())
        return s;

        for (int i = 0; i < s.size(); i++)
        {
            rows[rowIndex] = rows[rowIndex] + s[i];
            rowIndex += dir;
            if (rowIndex == 0 || rowIndex == numRows-1)
            dir*=-1;
        }

        for (int i = 1; i < numRows; i++)
        {
            rows[0] += rows[i];
        }
        return rows[0];
    }
};