class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for(int i = 1; i < nums.length; i++){
            int res = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    res = Math.max(res, dp[j] + 1);
                }
            }
            result = Math.max(result,res);
            dp[i] = res;
        }
        return result;
    }
}