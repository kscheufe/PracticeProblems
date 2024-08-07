class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>> output;
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });

        int index = 0;
        for (int i = 0; i < intervals.size(); i++)//for each vector
        {
            if (index == 0 || output[index-1][1] < intervals[i][0])//if the next start is greater than the current end (no overlap)
            {
                //add to output
                output.push_back(intervals[i]);
                index++; 
            }
            else 
            {//update the previous index interval's end if appropriate
                output[index-1][1] = max(output[index-1][1], intervals[i][1]);
            }
        }


        return output;
    }
};