class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        int left = 0;
        int right = x;
        int middle = left + (right - left) / 2;
        while(left <= right){
            if(middle * middle - x == 0){
                return middle;
            }
            if(middle > x / middle){
                right = middle - 1;
                left = left;
                middle = left + (right - left) / 2;
            }else{
                left = middle + 1;
                right = right;
                middle = left + (right - left) / 2;
            }
        }
        return right;
    }
}