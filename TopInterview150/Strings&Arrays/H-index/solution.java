/*
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

 

Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1
 

Constraints:

n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000
 */

 //fast but lots of memory
//count how many citations are still required for whatever h index
//at most 5000 papers, each paper has at most 1000 citations
class Solution {
    public int hIndex(int[] citations) {
        //create an array of size 1001 (highest value for h index)
        int[] hIndexPossibilities = new int[1001];
        //iterate through the loop, adding 1 count to position x when the value is x
        for (int i = 0; i < citations.length; i++)
        {
            hIndexPossibilities[Math.min(1000, citations[i])]++;
            //max 1000 from question parameters
        }
        //from 1000 to 0, 
            //add the count of papers above currIndex, 
            //return the first array position where count >= its index
        int count = 0;
        for (int i = hIndexPossibilities.length-1; i >= 0 ; i--)
        {
            count+=hIndexPossibilities[i];
            if (count >= i)
            {
                return i;
            }
        }
        return -1;
    }
}