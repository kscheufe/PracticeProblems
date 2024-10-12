/*
There are a total of numCourses courses you have to take, labeled from 0 
to numCourses - 1. You are given an array prerequisites where 
prerequisites[i] = [ai, bi] indicates that you must take course bi first 
if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to 
first take course 1.
Return the ordering of courses you should take to finish all courses. If 
there are many valid answers, return any of them. If it is impossible to 
finish all courses, return an empty array.

 

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you 
should have finished course 0. So the correct course order is [0,1].

Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you 
should have finished both courses 1 and 2. Both courses 1 and 2 should be 
taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is 
[0,2,1,3].

Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
*/
class Solution {
    //create the graph
    Map<Integer, List<Integer>> graph = new HashMap<>(); 
    int[] visit;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //populate the graph
        for (int i = 0; i < numCourses; i++)
        {
            graph.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) 
        {
            int course = prereq[0];
            int prerequisiteCourse = prereq[1];
            //edge from prerequisite to course
            graph.get(course).add(prerequisiteCourse);
        }

        visit = new int[numCourses];
        List<Integer> outputList = new ArrayList<>();
        //slither through the dark, when you reach the end of a distinct line you can return those courses

        //perfrom dfs on each course, adding it to output in reverse order
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {//if course is unvisited
                List<Integer> currOrder = populateOutput(i);
    //int[] currOrder = populateOutput(i);
                if (currOrder == null) {//perform dfs on it
                    return new int[0];//cycle detected, needs to be able to take ALL courses
                }
                outputList.addAll(currOrder);//[outputIndex = currOrder[j]];
                
            }
        }
        //Collections.reverse(outputList);//I know that I'm adding things backwards, this just seems easier, but is not good coding principles
        int[] output = new int[outputList.size()];
        for (int i = 0; i < outputList.size(); i++)
        {
            output[i] = outputList.get(i);
        }
        return output;
    }
    private List<Integer> populateOutput(int course) {
        if (visit[course] == 1) return null;//cycle found
        if (visit[course] == 2) return new ArrayList<>();//branch already fully processed

        visit[course] = 1;//mark as visiting

        //create current list
        List<Integer> current = new ArrayList<>();
        
        //explore neighbors (dependent courses)
        for (int neighbor: graph.get(course))
        {
            List<Integer> prefix = populateOutput(neighbor);
            if (prefix == null) return null;
            current.addAll(prefix);
            //if (populateOutput(neighbor)) return true;//cycle detected in neighbor
        }

        //adds int id of the course to current
        current.add(course);
        
        visit[course] = 2;

        return current; //no cycles found from this course
    }
}