/**
 * 1. Problems:
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * Follow up: Could you minimize the total number of operations done?
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Two pointers.
     * 2. Complexity:
     * Time:O(n)
     * Space:O(1)
     */
    /
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0;
        int nonZeroIndex = 0;
        int n = nums.length;
        while(nonZeroIndex < n && zeroIndex < n){
            while(zeroIndex < n && nums[zeroIndex] != 0){
                zeroIndex++;
            }
            if(zeroIndex == n){
                continue;
            }
            while(nonZeroIndex < n && nums[nonZeroIndex] == 0){
                nonZeroIndex++;
            }
            if(nonZeroIndex == n){
                continue;
            }
            if(zeroIndex < nonZeroIndex){
                swap(nums, zeroIndex, nonZeroIndex);
            }else{
                nonZeroIndex++;
            }
        }
    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}