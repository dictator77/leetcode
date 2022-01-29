class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }
        int result = 0;
        for(int i = 0, j = 1; j < s.length(); j++){
            for(int h = i; h < j; h++){
                if(s.charAt(h) == s.charAt(j)){
                    i = h + 1;
                    break;
                }
            }
            if(j - i + 1 > result){
                result = j - i + 1;
            }
        }
        return result;
    }
}