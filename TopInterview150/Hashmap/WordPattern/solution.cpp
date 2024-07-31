class Solution {
public:
    bool wordPattern(string pattern, string s) {
        unordered_map<char, string> ps;
        unordered_map<string, char> sp;
        vector<string> words;
        istringstream stream(s);
        string word;

        //create the vector of words
        while (stream >> word)
        {
            words.push_back(word);
        }

        if (pattern.length() != words.size())
            return false;

        for (int i = 0; i < pattern.length(); i++)
        {
            word = words[i];
            char cha = pattern[i];
            if (ps.find(cha) == ps.end())
            {
                ps[cha] = word;
            }
            else if (ps[cha] != word)
            {
                return false;
            }
            if (sp.find(word) == sp.end())
            {
                sp[word] = cha;
            }
            else if (sp[word] != cha)
            {
                return false;
            }
        }
        return true;
    }
};