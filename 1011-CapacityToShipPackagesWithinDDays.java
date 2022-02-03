class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int high = 0;
        int low = 0;
        for(int i = 0; i < weights.length; i++){
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        while(low < high){
            int middle = low + (high - low) / 2;
            int count = 1;
            int sum = 0;
            for(int i = 0;i < weights.length; i++){
                sum+=weights[i];
                if(sum > middle){
                    sum = weights[i];
                    count++;
                    if(count > days){
                        break;
                    }
                }
            }
            if(count > days){
                low = middle + 1;
            }else{
                high = middle;
            }
        }
        return low;
    }
}