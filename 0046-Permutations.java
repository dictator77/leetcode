/**
 * 1. Problems:
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
/
class Solution {
    /**
     * 1. Approach:
     * backtrack;
     *
     * 2. Complexity:
     * Time:O(n*n!)
     * Space:O(n)
     *
     * 3. Mistakes & Improvements:
     * 1)use a factor to record the count of nums that has been recorded. Then swap the index i and index first to
     * make sure every time the index first element is not be choosen.
     * 
     */
    /
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 1){
            res.add( Arrays.stream(nums).boxed().toList());
        }else{
            permutation(res, nums, new ArrayList<>(), 0);
        }
        return res;
    }
    private void permutation(List<List<Integer>> res, int[] nums, List<Integer> list, int first){
        if(first == nums.length){
            res.add(new ArrayList(list));
        }else{
            for(int i = first; i < nums.length; i++){
                list.add(nums[i]);
                swap(nums, first, i);
                permutation(res, nums, list, first+1);
                list.remove(list.size() - 1);
                swap(nums, first, i);
            }
        }
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}