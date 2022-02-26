/**
 * 1. Problems:
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
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
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int temp1 = nums[0];
        int temp2 = nums[0];
        int temp3 = nums[0];
        for(int i = 1; i < length; i++){
            temp1 = Math.max(temp1, temp2);
            int curr2 = temp2;
            temp2 = Math.max(Math.max(temp3 * nums[i], temp2 * nums[i]), nums[i]);
            temp3 = Math.min(Math.min(temp3 * nums[i], curr2 * nums[i]), nums[i]);
        }
        return Math.max(temp1, temp2);
    }
}