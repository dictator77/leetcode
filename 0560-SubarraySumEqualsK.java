/**
 * 1. Problems:
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
/
class Solution {
    /**
     * 1. Approach:
     * Using HashMap and Cumulative Sum
     *
     * 2. Complexity
     * Time:O(N)
     * Space:O(N)
     */
    /
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int presum = 0;
        int count = 0;
        for(int i : nums){
            map.put(presum, map.getOrDefault(presum, 0) + 1);
            presum += i;
            count += map.getOrDefault(presum - k, 0);
        }
        return count;
    }
}