class Solution {
    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        while(left < right){
            int middle = left + (right - left) / 2;
            int sum = 0;
            int count = 1;
            for(int num : nums){
                if(sum + num > middle){
                    sum = 0;
                    count++;
                    if(count > m){
                        break;
                    }
                }
                sum += num;
            }
            if(count > m){
                left = middle+1;
            }else{
                right = middle;
            }
        }
        return left;
    }
}