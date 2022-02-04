/**
 * 1.Problem
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 *
 *
 * 2.Example
 * Example 1:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * Example 2:
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * 3.Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */

class Solution {
    /**
     * 1.Approach
     * HashMap
     *
     * 2.Complexity
     * time:O(n)
     * Space:O(n)
     */

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                temp--;
            }else{
                temp++;
            }
            if(!map.containsKey(temp)){
                map.put(temp,i);
            }else{
                res = Math.max(i - map.get(temp), res);
            }
        }
        return res;
    }
}