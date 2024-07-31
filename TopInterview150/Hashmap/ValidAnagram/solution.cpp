class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> counts;
        for (char c: s)
        {
            if (counts.find(c) != counts.end())
            {
                counts[c] += 1;
            }
            else counts[c] = 1;
        }
        for (char c: t)
        {
            if (counts.find(c) == counts.end())
            {
                return false;
            }
            counts[c]--;
        }
        for (const auto& count : counts)
        {
            if (count.second != 0)
                return false;
        }
        return true;
    }
};