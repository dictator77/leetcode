/**
 * 1. Problems:
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 *
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * 3. Constraints:
 *
 * 0 <= n <= 105
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dynamic programming
     * 2. Complexity:
     * Time:O(n)
     * Space:O(n)
     */
    /
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        if(n == 0){
            return ans;
        }
        ans[1] = 1;
        if(n == 1){
            return ans;
        }
        int count = 2;
        for(int i = 2; i < n + 1; i++){
            if(i == count){
                ans[i] = 1;
                count *= 2;
                continue;
            }
            if(i > count / 2){
                ans[i] = ans[i - count / 2] + 1;
            }
        }
        return ans;
    }
}