/**
 * 1. Problems:
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * 3. Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
/
class Solution {
    /**
     * 1. Approach:
     *
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public int majorityElement(int[] nums) {
        int value = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(value == nums[i]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                value = nums[i + 1];
            }
        }
        return value;
    }
}