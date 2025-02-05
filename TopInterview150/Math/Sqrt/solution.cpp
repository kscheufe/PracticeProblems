class Solution {
public:
    int mySqrt(int x) {
        if (x==0 || x==1) return x;
        int right = x;
        int left = 1;
        int mid;
        while (right >= left)
        {
            mid = left + (right - left)/2;
            if ((long) mid*mid < x)
            {
                left = mid + 1;
            }
            else if ((long)mid*mid == x)
            {
                return mid;
            }
            else 
                right = mid - 1;
        }
        return right;
    }
};