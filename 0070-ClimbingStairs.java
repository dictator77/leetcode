/**
 * 1. Problems:
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * 3. Constraints:
 *
 * 1 <= n <= 45
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dynamic Programming;
     *
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        int pre1 = 2;
        int pre2 = 1;
        for(int i = 3; i <= n; i++){
            int temp = pre1;
            pre1 = pre1 + pre2;
            pre2 = temp;
        }
        return pre1;
    }
}