/*
There are some spherical balloons taped onto a flat wall that represents 
the XY-plane. The balloons are represented as a 2D integer array points 
where points[i] = [xstart, xend] denotes a balloon whose horizontal 
diameter stretches between xstart and xend. You do not know the exact 
y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) 
from different points along the x-axis. A balloon with xstart and xend 
is burst by an arrow shot at x if xstart <= x <= xend. There is no limit 
to the number of arrows that can be shot. A shot arrow keeps traveling up
infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

 

Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
Example 2:

Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
Example 3:

Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 

Constraints:

1 <= points.length <= 105
points[i].length == 2
-231 <= xstart < xend <= 231 - 1
 */


 /*
moving from left to right, one will have to be shot at most at the very 
right edge of the first balloon. it can be shot anywhere in that balloon's 
range to maximize pops (and should maximize popping the leftmost balloons
of other rows as well)

in that sense you could just keep finding the leftmost balloon's rightmost
edge and shoot there, knocking out every other balloon that overlaps with it

if there are ties for leftmost, shoot at the "leftest" right edge

not necessarily. if there are two balloons [1, 11] and [4, 5], shooting
at 11 would require two shots

adversely, if you go with the leftmost end position of all balloons, 
this should work. if two balloons overlap, the leftmost end will have to 
overlap with any other balloons in the overlap. if another ended further
left, it's end would be the leftmost, and if it started further right it 
wouldn't have an overlap and would require another shot anyways

----------------------------------------------------------------

so it seems as though we need to repetitively find the leftmost xend,
then remove that balloon and all others that overlap this position (have
a start <= xend), increment a counter, and repeat until all are shot

instead of removing elements, we could instead keep a value representing
the next viable xstart we could find elements at, and only consider the 
elements after it during shot locating. additionally we could return when
no balloons start after this pointer
  */
class Solution {
    public int findMinArrowShots(int[][] points) {
        int counter = 1;
        int rightmostStart = Integer.MIN_VALUE;
        int leftmostEnd = Integer.MAX_VALUE;
        for (int[] x: points)
        {
            rightmostStart = Math.max(rightmostStart, x[0]);
            leftmostEnd = Math.min(leftmostEnd, x[1]);
        }

        if (leftmostEnd == Integer.MAX_VALUE || rightmostStart == Integer.MIN_VALUE) return 1;

        while (leftmostEnd < rightmostStart)
        {//break condition when no balloons remain to shoot
            counter++;
            System.out.println("shot at " + leftmostEnd);
            int temp = leftmostEnd;
            leftmostEnd = Integer.MAX_VALUE;//reset the leftmost end to find the nect
            for (int[] x : points)
            {
                if (x[0] > temp)//find the non-overlappers
                {
                    leftmostEnd = Math.min(leftmostEnd, x[1]);
                }
            }
        }
        

        return counter;
    }
}