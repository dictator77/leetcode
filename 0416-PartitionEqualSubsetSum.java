/**
 * 1. Problems:
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dyanmic programming
     * 2. Complexity:
     * Time:O(target*n)
     * Space:O(target)
     */
    /
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int maxnum = 0;
        for(int num : nums){
            sum += num;
            maxnum = Math.max(maxnum, num);
        }
        if(nums.length < 2 || maxnum > sum - maxnum || sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[] count = new boolean[target + 1];
        count[0] = true;
        for(int num : nums){
            for(int j = target; j >= num; j--){
                count[j] = count[j] || count[j-num];
            }
        }
        return count[target];
    }
}