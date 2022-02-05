/**
 * 1. Problem:
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 * 2.Examples:
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
/

/**
 * method1:
 * hashMap
 */
        /
class Solution {
    /**
     * 1. Approach
     * Array/Indexing. One of the challenges of this problem is to have constant extra space. Imagine that there is no
     * such requirement, a fairly naive approach would be having a hashset storing the numbers in array and iterate
     * through 1 to N. With the requirement, the problem becomes how to model HashSet behavior using Array. One way is
     * to exploit the array index to indicate whether a positive indeed exist or not. To achieve this, we need:
     * - Use sign to indicate existence of positive number
     * - To eliminate the actual negative number's impact, one loop is needed to initialize those number to a number
     *   that is irrelevant (e.g. nums.length + 1, this number will be ignored in the loop for indexing)
     *
     * 2. Complexity
     * Time O(N)
     * Space (1)
     *
     * 3. Mistakes
     * 1) Negative/Zero number initialization
     * Don't initialize it to be zero. For example, if some number in array points to index of number which is zero, then
     * this number(index) will not be negated as the element it contains is zero.
     *
     * 2) Zero-based Index instead of One-based Index
     * If the index starts from 1, then it will throw up a problem in case [1], the loop will simply be skipped and the
     * returned result will be nums.length + 1 = 2.
     *
     * @param nums
     * @return
     */
    /
    public int firstMissingPositive(int[] nums) {
        int res = nums.length + 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0){
                nums[i] = nums.length + 1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i]) <= nums.length){
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                res = i + 1;
                break;
            }
        }
        return res;
    }
}

/**
 * method2:
 * 
 */
/

class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}