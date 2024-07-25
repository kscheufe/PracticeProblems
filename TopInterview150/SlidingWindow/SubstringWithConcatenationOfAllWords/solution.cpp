class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        int wordLen = words[0].size();
        int numWords = words.size();
        int windowSize = wordLen*numWords;
        vector<int> output;

        //check boundary cases
        if (windowSize > s.length())
        {
            return output;
        }

        //create hashmap
        unordered_map<string, int> targetWordsMap;
        //populate hashmap with words vector and counts
        for (int i = 0; i < words.size(); i++)
        {
            if (targetWordsMap.find(words[i]) != targetWordsMap.end())
            {
                targetWordsMap[words[i]]++;
            }
            else targetWordsMap.insert({words[i], 1});
        }

        //iterate through the possible starting positions of the sliding window
        //while checking for matches/lack thereof
        for (int i = 0; i < wordLen; i++)
        {
            int left = i;
            int right = i;
            unordered_map<string, int> currCountMap;
            int count = 0;

            //slide the windoe right wordLen at a time
            /* for example words[] = foo, bar, s.length == 10, 
                it will check starting indexes:
                0, 3, 6,    
                1, 4, 7,
                2, 5
                which is really odd but apparently optimal
            */
            while (right + wordLen <= s.length())
            {
                string word = s.substr(right, wordLen);
                right += wordLen;

                //if not in map
                if (targetWordsMap.find(word) == targetWordsMap.end())
                {
                    currCountMap.clear();
                    left = right;//because right wasn't viable
                    count = 0;//reset count
                }
                else //otherwise add it to the correct count
                {
                    currCountMap[word]++;//automatically handles new word additions
                    count++;

                    while (currCountMap[word] > targetWordsMap[word])
                    {
                        string leftWord = s.substr(left, wordLen);
                        currCountMap[leftWord]--;
                        count --;
                        left += wordLen;
                    }
                    if (count == numWords)
                        output.push_back(left);
                }
            }

        }
        return output;
    }
};