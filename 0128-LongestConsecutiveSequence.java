class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x : nums){
            if(!map.containsKey(x)){
                int left = map.containsKey(x-1) ? map.get(x-1) : 0;
                int right = map.containsKey(x+1) ? map.get(x+1) : 0;
                int sum = left + right + 1;
                result = Math.max(result, sum);
                map.put(x,sum);
                map.put(x-left,sum);
                map.put(x+right,sum);
            }else{
                continue;
            }
        }
        return result;
    }
}