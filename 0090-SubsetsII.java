/**
 * 1. Problem:
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * 3. Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
/
class Solution {
    /**
     * 1. Approach:
     * Dyanamic Programming
     * 2. Complexity:
     * Time:O(n*2^n)
     * Space:O(2^n)
     */
    /
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> initSub = new ArrayList<>();
        res.add(initSub);
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int time = res.size();
            if(i > 0 && nums[i] == nums[i - 1]){
                for(int j = 0; j < time; j++){
                    List<Integer> list = res.get(j);
                    List<Integer> sub = new ArrayList<>(list);
                    if(sub.contains(num)){
                        sub.add(num);
                        if(!res.contains(sub)){
                            res.add(sub);
                        }
                    }
                }
            }else{
                for(int j = 0; j < time; j++){
                    List<Integer> list = res.get(j);
                    List<Integer> sub = new ArrayList<>(list);
                    sub.add(num);
                    res.add(sub);
                }
            }
        }
        return res;
    }
}