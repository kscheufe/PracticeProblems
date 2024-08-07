/*
You are given an array of non-overlapping intervals intervals where 
intervals[i] = [starti, endi] represent the start and the end of the ith 
interval and intervals is sorted in ascending order by starti. You are 
also given an interval newInterval = [start, end] that represents the 
start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in 
ascending order by starti and intervals still does not have any 
overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a 
new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^5
intervals is sorted by starting in ascending order.
newInterval.length == 2
0 <= start <= end <= 10^5
 */


 /* this solution only iterates through the array once */
 class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;//for indexing
        int n = intervals.length;//for shorthand notation

        //while new interval doesn't overlap
        while (i < n && newInterval[0] > intervals[i][1])
        {
            res.add(intervals[i]);
            i++;
        }

        //once it does overlap, every entry until intervals[i][1] > newInt[1] will overlap
        while (i < n && newInterval[1] >= intervals[i][0])
        {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            //these seem like they could add unnecessary calculations by continuously updating
            i++;
        }
        res.add(newInterval);

        //add the remaining elements
        while (i < n)
        {
            res.add(intervals[i]);
            i++;
        }

        //convert back to int[][]
        int ans[][] = new int[res.size()][];
        for (int j = 0; j < res.size(); j++)
        {
            ans[j] = res.get(j);
        }

        return ans;
    }
}


 /* my solution that incrementally deals with all the hidden test case requirements
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length+1][2];
        if (intervals.length == 0)
        {
            newArr[0] = newInterval;
            return newArr;
        }
        int index = 0;
        boolean overlap = false;
        //iterate through, check for non overlapping case
        for (int curr = 0; curr < intervals.length; curr++)
        {
            if (intervals[curr][0] > newInterval[1] || intervals[curr][1] < newInterval[0])
            {
                continue;
            }
            overlap = true;
            break;
        }
        //if no overlap, insert it in the proper place
        if (!overlap)
        {
            int insertIndex = -1;
            //if new interval goes first
            if (intervals[0][0] > newInterval[0])
            {
                newArr[0] = newInterval;
                index = 1;
                for (int i = 0; i < intervals.length; i++)
                {
                    newArr[index++] = intervals[i];
                }
            }
            //if new interval goes last (already checked for no overlap)
            else if (intervals[intervals.length-1][0] < newInterval[0])
            {
                for (int i = 0; i < intervals.length; i++)
                {
                    newArr[index++] = intervals[i];
                }
                newArr[intervals.length] = newInterval;
            }
            //otherwise, find the index to insert the new interval
            else
            {
                int inserted = 0;
                for (int i = 0; i < intervals.length;i++)
                {
                    if (intervals[i][0] > newInterval[0] && inserted == 0)
                    {
                        newArr[i] = newInterval;
                        inserted++;
                    }
                    newArr[i+inserted] = intervals[i];
                }
            }
            return newArr;
        }



        else //if there is an overlap
        {
            int startValue = newInterval[0];
            int endValue = newInterval[1];
            //find the start value from the left
            for (int i = 0; i < intervals.length; i++)
            {
                if (intervals[i][1] >= newInterval[0])
                {
                    startValue = Math.min(newInterval[0], intervals[i][0]);
                    break;
                }
            }
            //find the end value from the right
            for (int i = intervals.length-1; i >= 0; i--)
            {
                if (intervals[i][0] <= newInterval[1])
                {
                    endValue = Math.max(intervals[i][1], newInterval[1]);
                    break;
                }
            }
            //add everything to output array
            for (int i = 0; intervals[i][0] < startValue; i++)
            {
                newArr[index++] = intervals[i];
            }
            newArr[index][0] = startValue;
            newArr[index++][1] = endValue;
            for (int i = 0; i < intervals.length; i++)
            {
                //if already added, continue
                if (intervals[i][0] <= endValue) continue;
                newArr[index++] = intervals[i];
            }

            //trim any possible [0, 0] entries
            int i = 1;
            for (; newArr[i][0] != 0; i++) {}
            int[][] retArr = new int[i][2];
            for (int j = 0; j < i; j++)
            {
                retArr[j] = newArr[j];
            }

            return retArr;
        }
    }
}
 */