/*
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

 

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

 

Constraints:

1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
 */

 class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
    }
}

 //this method works but is too slow with lists. you have to use maps
 /*
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {        
        int wordLength = words[0].length();
        int numWords = words.length;
        int concatLength = wordLength*numWords;
        List<Integer> output = new ArrayList<Integer>();
        List<String> wordsDuplicate = new ArrayList<>(Arrays.asList(words));
        
        //at every index you are checking the same (concatLength) number of 
        //characters, split into numWords groups of wordLength characters

        //scratch that, apparently you have to check every index
        for (int p1 = 0; p1 <= s.length()-concatLength; p1++)
        {
            String currentOption = s.substring(p1, p1+concatLength);
            //System.out.println(p1 + ", " + currentOption);
            
            //for each word in the current concatLength substring
            for (int j = 0; j < concatLength; j+= wordLength)
            {
                //if the current word option is not in the words list
                if (!wordsDuplicate.contains(currentOption.substring(j, j+wordLength)))
                {
                    break;//move on to the next concatenated string option
                }
                //otherwise, if it does contain it, remove it and move on
                wordsDuplicate.remove(currentOption.substring(j, j+wordLength));
            }
            //if all words were found, it is a concatenated substring, so add it to the output array
            if (wordsDuplicate.isEmpty())
            {
                output.add(p1);
            }
            //reset the words bank
            wordsDuplicate = new ArrayList<>(Arrays.asList(words));
             
        }
        return output;
    }
}
     */
