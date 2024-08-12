class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end(), [](const vector<int>& a, const vector<int>& b)
        {
            return a.back() < b.back();
        });
        int counter = 1;
        int leftmostEnd = points[0][1];
        for (vector<int> point : points)
        {
            if (point[0] > leftmostEnd)
            {
                counter++;
                leftmostEnd = point[1];   
            }
        }

        return counter;
    }
};