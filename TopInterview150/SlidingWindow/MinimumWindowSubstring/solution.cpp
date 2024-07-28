class Solution {
public:
    string minWindow(string s, string t) {
        //populate hashmap with t values
        unordered_map<char, int> targetMap;
        string output = "";
        //populate targetMap
        for (int i = 0; i < t.length(); i++)
        {
            if (targetMap[t[i]] > 0)
            {
                targetMap[t[i]]++;
            }
            else targetMap[t[i]] = 1;
        }

        //now iterate through source string looking for target
        int left = 0;
        unordered_map<char, int> currentMap;
        for (int right = 0; right < s.length(); right++)
        {
            if (targetMap.find(s[right]) == currentMap.end())
            {//if current char is not needed, continue
                continue;
            }
            else 
            {
                //add current char to currentMap
                if (currentMap[s[right]] > 0)
                {
                    currentMap[s[right]]++;
                }
                else currentMap[s[right]] = 1;

                //check if there's enough chars to create a substring
                bool enoughChars = true;
                for (const auto& entry : targetMap)
                {
                    char key = entry.first;
                    int value = entry.second;

                    if (currentMap.find(key) == currentMap.end() || currentMap.at(key) < value)
                    {
                        enoughChars = false;
                        break;
                    }
                }
                
                if (enoughChars)
                {
                    //reduce the front as much as possible
                    for (left--; left <= right; left++)
                    {
                        char currentChar = s[left+1];
                        //if the letter isn't in the required list
                        if (targetMap.find(currentChar) == targetMap.end())
                        {
                            continue;//remove it and advace
                        }
                        //or if there are extra of this letter already
                        if (currentMap.at(currentChar) > targetMap.at(currentChar))
                        {
                            //reduce
                            currentMap[currentChar]--;
                            continue;
                        }
                        //otherwise reset left up 1 and break if the character can't be removed
                        left++;
                        break;
                    }
                    //calculate the new substr length and update if appropriate
                    if (right-left+1 < output.length() || output.length() ==0)
                    {
                        output = s.substr(left, right-left+1)
                    }
                }
            }
        }
        
        
        return output;
    }
};