#include <string>
class Solution {
public:
    int romanToInt(string s) {
        int total = 0;
        int x = s.size() -1;
        while (x >= 0)
        {
            if (s[x] == 'I')
            {
                total += 1;
            }
            else if (s[x] == 'V')
            {
                if (x != 0 && s[x-1] == 'I')
                {
                    total += 4;
                    x--;
                }
                else total += 5;
            }
            else if (s[x] == 'X')
            {
                if (x != 0 && s[x-1] == 'I')
                {
                    total += 9;
                    x--;
                }
                else total += 10;
            }
            
            else if (s[x] == 'L')
            {
                if (x != 0 && s[x-1] == 'X')
                {
                    total += 40;
                    x--;
                }
                else total += 50;
            }
            else if (s[x] == 'C')
            {
                if (x != 0 && s[x-1] == 'X')
                {
                    total += 90;
                    x--;
                }
                else total += 100;
            }
            else if (s[x] == 'D')
            {
                if (x != 0 && s[x-1] == 'C')
                {
                    total += 400;
                    x--;
                }
                else total += 500;
            }
            else if (s[x] == 'M')
            {
                if (x != 0 && s[x-1] == 'C')
                {
                    total += 900;
                    x--;
                }
                else total += 1000;
            }
            x--;
        }
        return total;
    }
};