/**
 * 1. Problems:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 *
 * 3. Constraints:
 *
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * BFS;
     * 2. Complexity:
     * Time:O(m+n)
     * Space:O(m+n)
     */
    /
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] count = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            map.computeIfAbsent(prerequisites[i][1], x -> new ArrayList<Integer>()).add(prerequisites[i][0]);
            count[prerequisites[i][0]]++;
        }
        int visited = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses;i++){
            if(count[i] == 0){
                q.offer(i);
                count[i]--;
                visited++;
            }
            while(!q.isEmpty()){
                int temp = q.poll();
                if(map.containsKey(temp)){
                    for(int num: map.get(temp)){
                        count[num]--;
                        if(count[num] == 0){
                            q.offer(num);
                            count[num]--;
                            visited++;
                        }
                    }
                }
            }
        }
        System.out.println(visited);
        return visited == numCourses;
    }
}