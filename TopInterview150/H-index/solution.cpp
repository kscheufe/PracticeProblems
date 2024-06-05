class Solution {
public:
    int hIndex(vector<int>& citations) {
        int count = 0;
        int n = citations.size();
        vector<int> hIndices(n+1, 0);//declares size n+1
        for (int i = 0; i < citations.size(); i++)
        {
            hIndices[std::min(citations[i], n)]++;
        }
        for (int i = n; i >= 0; i--)
        {
            count += hIndices[i];
            if (count >= i)
            {
                return i;
            }
        }
        return -1;
    }
};