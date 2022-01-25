class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int resultlength = 0;
        int nowlength = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i+1]){
                nowlength++;
            }else{
                if(nowlength > resultlength){
                    resultlength = nowlength;
                }
                nowlength = 0;
            }
        }
        if(nowlength > resultlength){
            resultlength = nowlength;
        }
        return resultlength + 1;
    }
}