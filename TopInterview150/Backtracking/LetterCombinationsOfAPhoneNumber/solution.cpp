class Solution {
    public:
        vector<string> letterCombinations(string digits) {
            vector<string> result;
            if (digits.length() == 0) return result;
            //create map
            std::unordered_map<char, std::string> map = {
                {'2', "abc"},
                {'3', "def"},
                {'4', "ghi"},
                {'5', "jkl"},
                {'6', "mno"},
                {'7', "pqrs"},
                {'8', "tuv"},
                {'9', "wxyz"}
            };

            string comb;
            recurse(digits, 0, comb, result, map);
            return result;
        }

        void recurse(string digits, int index, string& comb, vector<string>& result, unordered_map<char, string> map) {
            if (index == digits.length())
            {
                result.push_back(comb);
                return;
            }

            string curr = map[digits[index]];
            for (char c: curr)
            {
                comb += c;
                recurse(digits, index+1, comb, result, map);
                comb.pop_back();
            }
        }
    };