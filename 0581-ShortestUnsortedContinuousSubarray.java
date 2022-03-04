/**
 * 1. Problems:
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: 0
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 0
 *
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 *
 * Follow up: Can you solve it in O(n) time complexity?
 */
/
class Solution {
    /**
     * 1. Approach:
     * two pointers.
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int mmin = Integer.MAX_VALUE;
        int mmax = Integer.MIN_VALUE;
        int left = -1;
        int right = -1;
        for(int i = 0; i < n; i++){
            if(mmax > nums[i]){
                right = i;
            }else{
                mmax = nums[i];
            }
            if(mmin < nums[n - i -1]){
                left = n - i - 1;
            }else{
                mmin = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}