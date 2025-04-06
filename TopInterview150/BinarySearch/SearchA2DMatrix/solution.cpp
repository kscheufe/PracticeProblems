class Solution {
    public:
        bool searchMatrix(vector<vector<int>>& matrix, int target) {
            int left = 0;
            int right = matrix.size()-1;
            int row = -1;

            while (left <= right) {
                int index = left + (right-left)/2;

                if (matrix[index][0] <= target && target <= matrix[index][matrix[index].size()-1]) {
                    row = index;
                    break;
                }

                else if (matrix[index][0] < target)
                {
                    left = index+1;
                }
                else right = index-1;
            }

            if (row == -1) return false;
            left = 0;
            right = matrix[row].size()-1;

            while (left <= right) {
                int index = left + (right-left)/2;
                if (matrix[row][index] == target) return true;
                else if (matrix[row][index] < target) left = index+1;
                else right = index-1;
            }
            return false;
        }
    };