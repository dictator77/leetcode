/**
 * 1. Problems:
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
 *
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
 *
 * Return the maximum coins you can collect by bursting the balloons wisely.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [3,1,5,8]
 * Output: 167
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * Example 2:
 *
 * Input: nums = [1,5]
 * Output: 10
 *
 * 3. Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * 0 <= nums[i] <= 100
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dynamic Programming
     * 2. Complexity:
     * Time:O(n^3)
     * Space:O(n^2)
     */
    /
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        for(int i = 0; i < n; i++){
            val[i + 1] = nums[i];
        }
        val[0] = 1;
        val[n + 1] = 1;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 2; j < n + 2; j++){
                for(int k = i + 1; k < j; k++){
                    int sum = val[i] * val[k] * val[j];
                    sum = sum + rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }
}