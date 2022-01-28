class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            int count = 1;
            while(j <= i){
                min = Math.min(min, dp[i - j] + 1);
                count++;
                j = count * count;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}