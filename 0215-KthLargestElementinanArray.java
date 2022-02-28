/**
 * 1. Problems:
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * 3. Constraints:
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 */
/
class Solution {
    /**
     * 1. Approach:
     * quicksort
     * 2. Complexity:
     * Time:O(n*n)
     * Space:O(n)
     */
    /
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }
    private int quickSort(int[] nums, int l, int r, int k){
        int res = -1;
        if(l <= r){
            int partitionIndex = partition(nums, l, r);
            if(partitionIndex == nums.length - k){
                res = nums[partitionIndex];
            }else if(partitionIndex > nums.length - k){
                res = quickSort(nums, l, partitionIndex - 1, k);
            }else{
                res = quickSort(nums, partitionIndex + 1, r, k);
            }
        }
        return res;
    }

    private int partition(int[] nums, int l, int r){
        int pivot = l;
        int index = pivot + 1;
        for(int i = index; i <= r; i++){
            if(nums[i] < nums[pivot]){
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index - 1, pivot);
        return index - 1;
    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}