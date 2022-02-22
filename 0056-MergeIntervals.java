/**
 * 1. Problems:
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * 3. Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 */
class Solution {
    /**
     * 1. Approach:
     *
     * 2. Complexity:
     * Time:O(nlogn)
     * Space:O(logn)
     */
    /
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] interval1, int[] interval2){
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int i = 0;  i < intervals.length; i++){
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(res.size() == 0 || res.get(res.size() - 1)[1] < L){
                res.add(new int[]{L, R});
            }else{
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
