class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> output;
        unordered_map<string, vector<string>> map;
        for (string curr : strs)
        {
            //sort the string
            string sortedString = curr;
            sort(sortedString.begin(), sortedString.end());
            //if the sorted string doesn't exist in the map (C++ don't need to check for existence)
            map[sortedString].push_back(curr);
        }

        //now populate the output array
        for (const auto& entry : map)
        {
            output.push_back(entry.second);
        }

        return output;
    }
};