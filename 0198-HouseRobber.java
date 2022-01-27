class Solution {
    public int rob(int[] nums) {
        int dp1 = nums[0];
        if(nums.length == 1){
            return dp1;
        }
        int dp2 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int temp = dp2;
            dp2 = Math.max(dp1 + nums[i], dp2);
            dp1 = temp;
        }
        return dp2;
    }
}