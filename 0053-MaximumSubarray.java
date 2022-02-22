/**
 * 1. Problem:
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104

 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dynamic Programming
     *
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for(int num : nums){
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }
}