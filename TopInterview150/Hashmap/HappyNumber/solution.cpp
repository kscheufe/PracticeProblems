class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> set;
        while (n > 1 && set.find(n) == set.end())
        {
            set.insert(n);
            n = sumOfSquares(n);
        }
        return n == 1;
        
    }
    int sumOfSquares(int n)
    {
        int sum = 0;
        while (n > 0)
        {
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
};