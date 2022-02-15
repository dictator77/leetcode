/**
 * 1. Problems:
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
/
class Solution {
    /**
     * 1. Approach:
     * HashMap
     * 2. Complexity:
     * Time:O(N)
     * Space:O(N)
     */
    /
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.remove(nums[i]);
            }
        }
        int a = 0;
        for(Integer key : map.keySet()){
            a = key;
        }
        return a;
    }
}

class Solution {
    /**
     * 1. Approach:
     * bit operation
     * 2. Complexity:
     * Time:O(N)
     * Space:O(1)
     */
    /
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums){
            single ^= num;
        }
        return single;
    }
}