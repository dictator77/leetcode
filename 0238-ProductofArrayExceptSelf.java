/**
 * 1. Problems:
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * 3. Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * firstly, record the preproduct, then every preproduct product the backproduct.
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public int[] productExceptSelf(int[] nums) {
        int[] preproduct = new int[nums.length];
        preproduct[0] = 1;
        for(int i = 1; i < nums.length; i++){
            preproduct[i] = preproduct[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            preproduct[i] = preproduct[i] * temp;
            temp = temp * nums[i];
        }
        return preproduct;
    }
}