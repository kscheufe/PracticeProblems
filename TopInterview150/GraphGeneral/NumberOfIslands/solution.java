/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) 
and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent 
lands horizontally or vertically. You may assume all four edges of the 
grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */

 //interesting you could also do it in O(n): if touching 0s increment, if touching 2s decrement?
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1')
                {
                    islands++;
                    grid[i][j] = '2';//mark as seen
                    grid = traverseNeighbours(i, j, grid);
                }
            }
        }   
        return islands;
    }

    public char[][] traverseNeighbours(int i, int j, char[][] grid)
    {
        //System.out.println(i + ", " + j);//weird that commenting out this line drops it from 130ms to 2ms
        if (i != 0 && grid[i-1][j] == '1')//left
        {
            grid[i-1][j] = '2';//mark visited
            traverseNeighbours(i-1, j, grid);//check neighbours
        }
        if (i != grid.length-1 && grid[i+1][j] == '1')//right
        {
            grid[i+1][j] = '2';
            traverseNeighbours(i+1, j, grid);
        }
        if (j != grid[0].length-1 && grid[i][j+1] == '1')//bottom
        {
            grid[i][j+1] = '2';
            traverseNeighbours(i, j+1, grid);
        }
        if (j != 0 && grid[i][j-1] == '1')//top
        {
            grid[i][j-1] = '2';
            traverseNeighbours(i, j-1, grid);
        }
        
        return grid;
    }
}