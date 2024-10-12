/*
There are a total of numCourses courses you have to take, labeled from 0 
to numCourses - 1. You are given an array prerequisites where 
prerequisites[i] = [ai, bi] indicates that you must take course bi first 
if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to 
first take course 1.
Return true if you can finish all courses. Otherwise, return false.
 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*/
class Solution {
    //create a map connecting a course to it's prerequisites
    Map<Integer, List<Integer>> graph = new HashMap<>(); 
    int[] visit; //0 = unvisited, 1 = visiting, 2 = visited
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //basically just looking for cyclic dependencies
        //but have to count number of cyclic dependencies

        //build the graph (adjacency list)
        for (int i = 0; i < numCourses; i++)
        {
            graph.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) 
        {
            int course = prereq[0];
            int prerequisiteCourse = prereq[1];
            //edge from prerequisite to course
            graph.get(prerequisiteCourse).add(course);
        }

        //init visit arr
        visit = new int[numCourses];

        //check each course for cyclic dependencies
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {//if course is unvisited
                if (findCycles(i)) {//perform dfs on it
                    return false;//cycle detected, needs to be able to take ALL courses
                }
            }
        }

        return true;
    }
    private boolean findCycles(int course) {
        if (visit[course] == 1) return true;//cycle found
        if (visit[course] == 2) return false;//branch already fully processed

        visit[course] = 1;//mark as visiting

        //explore neighbors (dependent courses)
        for (int neighbor: graph.get(course))
        {
            if (findCycles(neighbor)) return true;//cycle detected in neighbor
        }

        visit[course] = 2;

        return false; //no cycles found from this course
    }
}