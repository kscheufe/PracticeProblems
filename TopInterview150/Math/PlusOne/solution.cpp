class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i = digits.size()-1; i > -2; i--)
        {
            if (i == -1)
            {
                vector<int> ret(digits.size() + 1, 0);
                ret[0] = 1;
                return ret;            
            }
            if (digits[i] != 9)
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        return digits;
    }
};