class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int p1 = 0;
        int longestLength = 0;
        for (int p2 = 0; p2 < s.size(); p2++)
        {
            while (s.substr(p1, p2-p1).find(s[p2]) != string::npos)
            {
                p1 += 1;
            }
            longestLength = max(longestLength, p2-p1+1);

        }
        return longestLength;
    }
};