/*
* 1.problems
* Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l)
* such that:
* 0 <= i, j, k, l < n
* nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
* 2.Examples
* Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
* Output: 2
* Explanation:
* The two tuples are:
* 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
* 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
*
* Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
* Output: 1
*
* 3.Constraints:
* n == nums1.length
* n == nums2.length
* n == nums3.length
* n == nums4.length
* 1 <= n <= 200
* -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
* */

class Solution {
    /*
    * 1. Approach
    * We aim to find all possible A[i] + B[j] + C[k] + D[l] = 0, that is, A[i] + B[j] = -(C[k] + D[l])
    * In other words, we need to count the number of all possible two-sums between A and B that equals
    * to opposite of any two-sum between C and D.
    * Thus, we enumerate all two-sums between C and D, and store sum-to-frequency mappings for reference.
    *
    * 2. Complexity
    * Time: O(n^2)
    * Space: O(n^2)
    * */

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num1 : nums1){
            for(int num2 : nums2){
                map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for(int num3 : nums3){
            for(int num4 : nums4){
                if(map.containsKey(- num3 - num4)){
                    result += map.get(- num3 - num4);
                }
            }
        }
        return result;
    }
}