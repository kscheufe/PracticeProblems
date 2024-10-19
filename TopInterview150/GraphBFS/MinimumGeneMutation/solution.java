/*
A gene string can be represented by an 8-character long string, with choices from 'A', 
'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to 
a gene string endGene where one mutation is defined as one single 
character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. 
A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, 
return the minimum number of mutations needed to mutate from startGene to 
endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be 
included in the bank.

 

Example 1:

Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
Example 2:

Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2
 

Constraints:

0 <= bank.length <= 10
startGene.length == endGene.length == bank[i].length == 8
startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
*/

import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> validGenes = new HashSet<>();
        HashSet<String> visitedGenes = new HashSet<>();
        validGenes.add(startGene);//add the start gene for consistency
        for ( int i = 0; i < bank.length; i++ )//add strings to set
        {
            validGenes.add(bank[i]);
        }
        if (!validGenes.contains(endGene)) return -1;//return if the output gene is not valid

        //build the graph - does not need to be done explicitly

        //bfs the graph while dynamically building it, 
            //don't even need to build it, just only add valid genes to queue, pure BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visitedGenes.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();//needs to be outside so it doesn't change
            //check all genes at current level
            for (int i = 0; i < size; i++)
            {
                String curr = queue.poll();
                if (curr.equals(endGene)) return mutations;

                for (String gene : validGenes)
                {
                    //check if each gene is validMutation and hasn't been added yet
                    if (!visitedGenes.contains(gene) && validMutation(gene, curr))
                    {
                        queue.add(gene);
                        visitedGenes.add(gene);
                    }
                }
            }
            mutations++;
        }



        return -1;//if not possible

    }

    public boolean validMutation(String a, String b)
    {
        int counter = 0;
        for (int i = 0; i < 8; i++)
        {
            if (a.charAt(i) != b.charAt(i))
            {
                counter++;
            }
        }
        return counter == 1;
    }
}