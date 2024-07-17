//in C++ the optimal solution is actually just the original big if else statement
class Solution {
public:
    string intToRoman(int num) {
        string output = "";
        std::array<int, 13> nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        string chars[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < nums.size(); i++)
        {
            while (num >= nums[i])
            {
                num -= nums[i];
                output += chars[i];
            }
        }
        return output;
    }
};