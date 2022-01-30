class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }else if(nums.length == 3){
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);
        int dp3 = nums[1];
        int dp4 = Math.max(nums[1], nums[2]);
        for(int i = 3; i < nums.length; i++){
            int temp = dp2;
            dp2 = Math.max(dp1 + nums[i - 1], dp2);
            dp1 = temp;
            temp = dp4;
            dp4 = Math.max(dp3 + nums[i], dp4);
            dp3 = temp;
        }
        return Math.max(dp2, dp4);
    }
}