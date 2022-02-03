/*
* method 1:
* */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int low = i + 1, high = nums.length - 1; low < high;){
                int threesum = nums[i] + nums[low] + nums[high];
                if(threesum == 0){
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while(low < high && nums[low] == nums[low+1]) low++;
                    while(low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                }else if(threesum < 0){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return res;
    }
}



/*
* method2: transfer the question to TwoSum problem.
* O(n^2)
* ideas: the way to check whether the solution contain duplicate triplets.
* */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return res;
        }
        TreeSet<String> set = new TreeSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i + 1; j < nums.length; j++){
                if(map.containsKey(nums[j])){
                    String str = nums[i]+":"+nums[map.get(nums[j])]+":"+nums[j];
                    if(!set.contains(str)){
                        res.add(Arrays.asList(nums[i],nums[map.get(nums[j])],nums[j]));
                        set.add(str);
                    }
                }else{
                    map.put(0 - nums[i] - nums[j], j);
                }
            }
        }
        return res;
    }
}