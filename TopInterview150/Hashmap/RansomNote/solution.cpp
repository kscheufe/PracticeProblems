class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char, int> magazineCount;
        for (char c : magazine)
        {
            if (magazineCount.find(c) == magazineCount.end())
            {
                magazineCount.insert({c, 1});
            }
            else magazineCount[c]++;
        }
        for (char c: ransomNote)
        {
            if (magazineCount.find(c) == magazineCount.end() || magazineCount[c] == 0)
            {
                return false;
            }
            magazineCount[c]--;
        }
        return true;
    }
};