/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */

 class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineCount = new HashMap<>();
        for (char c : magazine.toCharArray())
        {
            if (magazineCount.containsKey(c))
                magazineCount.put(c, magazineCount.get(c)+1);
            else magazineCount.put(c, 1);
        }
        for (char c: ransomNote.toCharArray())
        {
            if (!magazineCount.containsKey(c) || magazineCount.get(c) == 0)
                return false;
            magazineCount.put(c, magazineCount.get(c)-1);
        }
        return true;
    }
}
