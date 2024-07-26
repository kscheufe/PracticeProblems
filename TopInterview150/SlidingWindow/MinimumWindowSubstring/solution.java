/*
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
*/


/*
  - so we need another hashmap to keep track of character counts
  - window size must adjust dynamically, with minimum size t.length() if needed

  left incremement logic could be something like: while (all characters quantities continue to meet the condition, move left forward)
*/

 class Solution {
    public String minWindow(String s, String t) {
        

        HashMap<String, Integer> targetLettersMap = new HashMap<>();
        for (char key: t.toCharArray())
        {
            String c = String.valueOf(key);
            if (targetLettersMap.containsKey(c))
            {
                targetLettersMap.put(c, targetLettersMap.get(c) + 1);
            }
            else
                targetLettersMap.put(c, 1);
        }

        
        int left = 0;
        String output = "";
        HashMap<String, Integer> currentLettersMap = new HashMap<>();

        //now iterate through the s String to look for matches
        for (int right = 0; right < s.length(); right++)
        {
            //convert it to a string just to keep it simple
            String c = String.valueOf(s.charAt(right));
            if (!targetLettersMap.containsKey(c))
            {
                continue;//if current char is not needed, move on to the next
            }
            else 
            {   //otherwise add/increment it in the current list
                if (currentLettersMap.containsKey(c))
                {
                    currentLettersMap.put(c, currentLettersMap.get(c) + 1);
                }
                else
                {
                    currentLettersMap.put(c, 1);
                }

                //check if the currentLettersMap contains everything in the targetLettersMap
                boolean enoughChars = true;
                for (Map.Entry<String, Integer> entry : targetLettersMap.entrySet())
                {
                    String key = entry.getKey();
                    int value = entry.getValue();

                    if (!currentLettersMap.containsKey(key) || currentLettersMap.get(key) < value)
                    {
                        enoughChars = false;
                        break;
                    }
                }

                //if it does contain all the necessary chars, remove all unnecessary chars before it
                if (enoughChars)
                {
                    for (left--; left <= right; left++)
                    {
                        String currentChar = String.valueOf(s.charAt(left+1));

                        //if the letter isn't in the required list 
                        if (!targetLettersMap.containsKey(currentChar))
                        {
                            continue;
                        }
                        //OR if there's enough of it anyways
                        if (currentLettersMap.get(currentChar) > targetLettersMap.get(currentChar))
                        {
                            //reduce
                            currentLettersMap.put(currentChar, currentLettersMap.get(currentChar) - 1);
                            //increment left
                            continue;
                        }
                        //otherwise reset left up 1 and break if the next character can't be removed
                        left++;
                        break;
                    }
                    if (right-left + 1 < output.length() || output.length() == 0)
                    {
                        output = s.substring(left, right+1);
                    }
                }
            }
        }

        
        return output;
    }
}
