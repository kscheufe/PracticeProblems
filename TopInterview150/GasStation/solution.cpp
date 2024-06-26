class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int total = 0;
        int curr = 0;
        int index = -1;
        for (int i = 0; i < gas.size(); i++)
        {
            curr += gas[i]-cost[i];
            total+= gas[i]-cost[i];
            if (curr >= 0 && index ==-1)
            {
                index = i;
            }
            if (curr < 0)
            {
                curr = 0;
                index = -1;
            }
        }
        if (total >= 0)
        {return index;}
        return -1;
    }
};