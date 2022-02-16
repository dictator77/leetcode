/**
 * 1. Problems:
 * You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.
 *
 * You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.
 *
 * For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.
 *
 * Return an array answer, where answer[j] is the answer to the jth query.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 *
 * Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
 * Output: [3,2,2]
 * Explanation: The points and circles are shown above.
 * queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.
 * Example 2:
 *
 *
 * Input: points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
 * Output: [2,3,2,4]
 * Explanation: The points and circles are shown above.
 * queries[0] is green, queries[1] is red, queries[2] is blue, and queries[3] is purple.
 *
 *
 * 3. Constraints:
 *
 * 1 <= points.length <= 500
 * points[i].length == 2
 * 0 <= xi, yi <= 500
 * 1 <= queries.length <= 500
 * queries[j].length == 3
 * 0 <= xj, yj <= 500
 * 1 <= rj <= 500
 * All coordinates are integers.
 *
 *
 * Follow up: Could you find the answer for each query in better complexity than O(n)?
 */
/
class Solution {
    /**
     * 1. Approach:
     * travese, and directly compute whether point is inside circle;
     * 2. Complexity:
     * Time:O(n*m)
     * Space:O(n)
     */
    /
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int temp = 0;
            for(int[] point : points){
                if(inOrOutside(point, queries[i])){
                    temp++;
                }
            }
            res[i] = temp;
        }
        return res;
    }
    private boolean inOrOutside(int[] points, int[] queries){
        if(Math.abs(points[0] - queries[0]) > queries[2] || Math.abs(points[1] - queries[1]) > queries[2]){
            return false;
        }
        double temp = Math.pow((points[0] - queries[0]), 2) + Math.pow((points[1] - queries[1]), 2);
        return temp <= Math.pow(queries[2], 2);
    }
}