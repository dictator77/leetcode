class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int factor2 = 2;
        int factor3 = 3;
        int factor5 = 5;
        int count = 1;
        while(count < n){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            dp[count++] = min;
            if(min == factor2) factor2 = 2 * dp[++index2];
            if(min == factor3) factor3 = 3 * dp[++index3];
            if(min == factor5) factor5 = 5 * dp[++index5];
        }
        return dp[n - 1];
    }
}