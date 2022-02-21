/**
 * 1. Problems:
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 *
 * 3. Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
/
class Solution {
    /**
     * 1. Approach:
     * binary search
     *
     * 2. Complexity:
     * Time:O(logn)
     * Space:O(1)
     *
     * 3. Mistakes & improvements:
     * the way to find the start and the end index of target by binary searching.
     */
    /
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int start = -1, end = -1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        start = left;
        if(start == nums.length || nums[start] != target){
            return new int[]{-1,-1};
        }
        right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        end = right;
        return new int[]{start, end - 1};
    }
}