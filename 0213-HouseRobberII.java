class Solution {
    public int rob(int[] nums) {
        int dp1 = nums[0];
        if(nums.length == 1){
            return dp1;
        }
        int dp2 = Math.max(nums[0], nums[1]);
        int dp3 = nums[1];
        if(nums.length == 2){
            return dp2;
        }
        int dp4 = Math.max(nums[1], nums[2]);
        for(int i = 2; i < nums.length - 1; i++){
            int temp = dp2;
            dp2 = Math.max(dp1+nums[i], dp2);
            dp1 = temp;
            temp = dp4;
            dp4 = Math.max(dp3+nums[i+1], dp4);
            dp3 = temp;
        }
        return Math.max(dp2,dp4);
    }
}