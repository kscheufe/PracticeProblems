class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> st;
        unordered_map<char, char> ts;
        for (int i = 0; i < s.length(); i++)
        {
            if (st.find(s[i]) == st.end())
            {
                st[s[i]] = t[i];
            }
            else if (st[s[i]] != t[i])
            {
                return false;
            }
            if (ts.find(t[i]) == ts.end())
            {
                ts[t[i]] = s[i];
            }
            else if (ts[t[i]] != s[i])
            {
                return false;
            }
        }
        return true;
    }
};