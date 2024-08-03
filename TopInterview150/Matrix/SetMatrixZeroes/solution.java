/*
Given an m x n integer matrix matrix, if an element is 0, set its entire 
row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */

 class Solution {
    public void setZeroes(int[][] matrix) {
        //go through row 0 and columns 0, hold 2 variables to determine if a o was found in them
        boolean column1zero = false;
        boolean row1zero = false;
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[i][0] == 0)
            {
                column1zero = true;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j++)
        {
            if (matrix[0][j] == 0)
            {
                row1zero = true;
                break;
            }
        }
        //go through matrix [1 to n][1 to m]
        //mark row 0 or column 0 in the appropriate space if a 0 is found
        for (int i = 1; i < matrix.length; i++)
        {
            for (int j = 1; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++)
        {
            System.out.print(matrix[0][j] + ", ");
        }
        System.out.println();
        for (int i = 1; i < matrix.length; i++)
        {
            System.out.println(matrix[i][0] + ", ");
        }
        //iterate through row 0 and column 0, setting the columns and rows to 0 if marked
        for (int i = 1; i < matrix.length; i++)
        {
            if (matrix[i][0] == 0)
            {
                for (int j = 1; j < matrix[0].length; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < matrix[0].length; j++)
        {
            if (matrix[0][j] == 0)
            {
                for (int i = 1; i < matrix.length; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        //check the 2 original variables and make the row 0 or column 0 all 0s if necessary
        if (column1zero)
        {
            for (int i = 0; i < matrix.length; i++)
            {
                matrix[i][0] = 0;
            }
        }
        if (row1zero)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                matrix[0][j] = 0;
            }
        }
    }
}

//extra space solution
/*
class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)   
            {
                if (matrix[i][j] == 0)
                {
                    rows.add(i);
                    break;//skip the rest of the elements to save some time
                }
            }
        }
        for (int j = 0; j < matrix[0].length; j++)
        {
            for (int i = 0; i < matrix.length; i++)
            {
                if (matrix[i][j] == 0)//if you encounter a zero
                {
                    for (i = 0; i < matrix.length; i++)
                    {
                        matrix[i][j] = 0;//set the column to zeroes
                    }
                    break;//break out to the next column
                }
            }
        }
        for (int index : rows)//set the rows identified earlier to 0s
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                matrix[index][j] = 0;
            }
        }
    }
}
     */