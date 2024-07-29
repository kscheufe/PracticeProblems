/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        //create a hashmap between the letters
        HashMap<Character, Character> stmap = new HashMap<>();
        HashMap<Character, Character> tsmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            //check if s[i] char already exists in the map
            if (!stmap.containsKey(s.charAt(i)))
            {
                //if it doesn't, add it
                stmap.put(s.charAt(i), t.charAt(i));
            }
            else 
            {
                //if it does, check if the mapping holds true}
                if (stmap.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }

            //check if s[i] char already exists in the map
            if (!tsmap.containsKey(t.charAt(i)))
            {
                //if it doesn't, add it
                tsmap.put(t.charAt(i), s.charAt(i));
            }
            else 
            {
                //if it does, check if the mapping holds true}
                if (tsmap.get(t.charAt(i)) != s.charAt(i))
                    return false;
            }
        }
        return true;
    }
}