/*
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
 

Solution
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        int currentOutputIndex = 0;
        output.add("");

        //sort the words into rows based on whether they fit
        for (int i = 0; i < words.length; i++)
        {
            if (output.get(currentOutputIndex) == "")//check if the line is empty so far, helps when only one word exactly fits into a line
            {
                output.set(currentOutputIndex, words[i]);
            }
            else if ((output.get(currentOutputIndex) + " " + words[i]).length() <= maxWidth)
            {
                if (output.get(currentOutputIndex).isEmpty()) 
                {
                    output.set(currentOutputIndex, words[i]);
                } 
                else 
                {
                    output.set(currentOutputIndex, output.get(currentOutputIndex) + " " + words[i]);
                }
            }
            else 
            {
                currentOutputIndex++;
                output.add(words[i]);
            }
        }//output is currently left aligned strings

        //justify each line except the last
        int spaceCounter = 0;
        int spacesToAdd = 0;
        int currentSpaceAdder = 0;
        for (int i = 0; i < output.size()-1; i++)//for each line
        {
            String originalString = output.get(i);
            spacesToAdd = maxWidth-originalString.length();//calculate the spaces to add
            for (int j = 1; j < originalString.length(); j++)//calculate the spaces existing
            {
                if (originalString.charAt(j) == ' ')
                {
                    spaceCounter++;
                }
            }
            //check for single word lines
            if (spaceCounter == 0)
            {
                for (int k = 0; k < spacesToAdd; k++)
                {
                    originalString += " ";
                }
                output.set(i, originalString);
                spaceCounter = 0;
                spacesToAdd = 0;
                currentSpaceAdder = 0;
                System.out.println(output.get(i));
                continue;
            }
            //say 15 spaces to add and 4 areas: 4, 4, 4, 3
            //add 3 spaces to all then 1 space to the first 3
            System.out.println(spaceCounter + "  " + i);
            currentSpaceAdder = spacesToAdd / spaceCounter;//rounds down with integer division
            spacesToAdd -= currentSpaceAdder*spaceCounter;//finds the leftover spaces to add after
            
            for (int j = 1; j < originalString.length(); j++)//for each character in the current line
            {
                if (originalString.charAt(j) == ' ')//if the character is a space
                {
                    //add currentSpaceAdder spaces to it
                    for (int k = 0; k < currentSpaceAdder; k++)
                    {
                        originalString = originalString.substring(0, j) + " " + originalString.substring(j, originalString.length());
                        j++;
                    }
                }
            }
            
            //now go through "spacesToAdd" times and add a single space to existing spaces 
            boolean added = false;
            int index = 0;
            while (spacesToAdd > 0)
            {
                if (originalString.charAt(index) == ' ' && added == false)
                {
                    originalString = originalString.substring(0, index) + " " + originalString.substring(index, originalString.length());
                    index++;
                    added = true;
                    spacesToAdd--;
                }
                else if (originalString.charAt(index) != ' ')
                {
                    added = false;
                }
                index++;
            }

            output.set(i, originalString);
            spaceCounter = 0;
            spacesToAdd = 0;
            currentSpaceAdder = 0;
            System.out.println(output.get(i));
        }

        //finally, add spaces to the last line
        String finalLine = output.get(output.size()-1);
        spacesToAdd = maxWidth - finalLine.length();
        for (int i = 0; i < spacesToAdd; i++)
        {
            finalLine += " ";
        }
        output.set(output.size()-1, finalLine);

        //output list of strings
        return output;
    }
}