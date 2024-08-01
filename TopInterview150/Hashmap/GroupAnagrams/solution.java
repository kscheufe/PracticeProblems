/*
Given an array of strings strs, group the anagrams together.
 You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a 
different word or phrase, typically using all the original letters 
exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();;
        for (String str : strs)
        {
            //sort the string
            char[] cArr = str.toCharArray();
            Arrays.sort(cArr);
            String sortedString = new String(cArr);
            //add a map entry if current sorted does not exist
            if (!map.containsKey(sortedString))
            {
                map.put(sortedString, new ArrayList<>());
            }
            //add the original string to the list
            map.get(sortedString).add(str);
        }
        //iterate through the hashMap entries
        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            //add the list of strings to the output
            output.add(entry.getValue());
        }

        return output;
    }
}