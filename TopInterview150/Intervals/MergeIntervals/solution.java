/*
Given an array of intervals where intervals[i] = [starti, endi], merge 
all overlapping intervals, and return an array of the non-overlapping 
intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> output = new ArrayList<>();
        //sort intervals[][] by first element in increasing order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] row : intervals) 
        {
            System.out.println(Arrays.toString(row));
        }
        for (int i = 0; i < intervals.length; i++)
        {
            System.out.println(Arrays.toString(intervals[i]));
            if (i == intervals.length-1)//if inspecting the last element
            {
                System.out.println(1);
                output.add(Arrays.asList(start, Math.max(intervals[i][1], end)));
            }
            else if (intervals[i+1][0] > end)//if next start is greater than current end
            {
                System.out.println(2);
                output.add(Arrays.asList(start, end));
                start = intervals[i+1][0];
                end = intervals[i+1][1];
            }
            else
            { 
                System.out.println(3);
                end = Math.max(end, intervals[i+1][1]);
            }
        }

        //convert to 2d array
        int[][] out = new int[output.size()][output.get(0).size()];
        for (int i = 0; i < output.size(); i++)
        {
            for (int j = 0; j < output.get(0).size(); j++)
            {
                out[i][j] = output.get(i).get(j);
            }
        }
        return out;
    }
}