/**
 * 1. Problems:
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * 3. Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up:Could you come up with a one-pass algorithm using only constant extra space?
 */
/
class Solution {
    /**
     * 1. Approach:
     * two pointers;
     * 2. Complexity:
     * Time:O(N)
     * Space:O(1)
     */
    /
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0; i <= right; i++){
            while(i <= right && nums[i] == 2){
                swap(nums, i, right);
                right--;
            }
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
            }
        }
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}