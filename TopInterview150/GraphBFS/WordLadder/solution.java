/*
A transformation sequence from word beginWord to word endWord using a 
dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... 
-> sk such that:

Every adjacent pair of words differs by a single letter.
Every s_i for 1 <= i <= k is in wordList. Note that beginWord does not 
need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, 
return the number of words in the shortest transformation sequence from 
beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/


//basic steps
/*
    1. Create a set of the valid strings for fast checking
    2. Check if target word is valid
    3. Add first word to queue and initialize bfs/counting parameters
    4. iterate through queue
        i) each time, check if the current word is the target
        ii) iterate through the set/list of valid words, checking to see 
            if each is a valid mutation
                a) if it is, add it to the queue for the next round and 
                   mark it visisted
        iii) increment count of changes
 */
import java.util.*;
//similar solution as before
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> validStrings = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++)
        {
            validStrings.add(wordList.get(i));
        }
        //early break for target invalid
        if (validStrings.contains(endWord) == false) return 0;

        Set<String> visitedStrings = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visitedStrings.add(beginWord);

        int wordsInChanges = 1;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            //for each element at current level
            for (int i =0; i < size; i++)
            {
                String curr = queue.poll();

                char[] word = curr.toCharArray();//why?

                //only checks a-z
                //also removes seen strings from valid set
                for (int j = 0; j < word.length; j++)
                {
                    char originalChar = word[j];
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        if (word[j] == c) continue;//if same string

                        word[j] = c;//check next mutation
                        String newWord = String.valueOf(word);

                        //return ans if found
                        if (newWord.equals(endWord)) return wordsInChanges+1;
                        if (validStrings.contains(newWord)) 
                        {
                            queue.offer(newWord);
                            validStrings.remove(newWord);
                        }
                    }
                    word[j] = originalChar;
                }

               /*
                // if you find it
                if (curr.equals(endWord)) return wordsInChanges;

                for (String word : wordList)//here, faster implementations check a-z for each index to see if it's a valid mutation and if it's in the list
                {
                    if (!visitedStrings.contains(word) && validMutation(curr, word))
                    {
                        visitedStrings.add(word);
                        queue.add(word);
                    }
                } */
            }

            wordsInChanges++;
        }


        return 0;
    }

    public boolean validMutation(String a, String b)
    {
        int counter = 0;
        for (int i = 0; i < a.length(); i++)
        {
            if (a.charAt(i) != b.charAt(i)) counter++;
        }

        return counter == 1;
    }
}