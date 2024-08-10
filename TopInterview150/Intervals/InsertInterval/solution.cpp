class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> output;
        int i = 0;
        int n = intervals.size();
        
        //while no overlap
        while (i < n && newInterval[0] > intervals[i][1])
        {
            output.push_back(intervals[i]);
            i++;
        }

        //while overlapping
        while ( i < n && newInterval[1] >= intervals[i][0])
        {
            newInterval[0] = min(intervals[i][0], newInterval[0]);
            newInterval[1] = max(intervals[i][1], newInterval[1]);
            i++;
        }
        output.push_back(newInterval);

        //for remaining elements after overlapping
        while (i < n)
        {
            output.push_back(intervals[i]);
            i++;
        }

        return output;
    }
};