class Solution {
public:
    string reverseWords(string s) {
        string word = "";
        string sentence = "";
        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] == ' ' && word == "")
            {
                continue;
            }
            else if (s[i] == ' ')
            {
                sentence = word + " " + sentence;
                word = "";
            }
            else
            {
                word += s[i];
            }
        }
        if (word != "")
        {
            sentence = word + " " + sentence;
        }
        return sentence.substr(0, sentence.size()-1);
    }
};