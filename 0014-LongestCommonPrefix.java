class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int minlength = 200;
        for(String str : strs){
            if(str.length() < minlength){
                minlength = str.length();
            }
        }
        for(int i = 0; i < minlength; i++){
            char temp = strs[0].charAt(i);
            for(String str : strs){
                if(temp != str.charAt(i)){
                    return result;
                }
            }
            result += temp;
        }
        return result;
    }
}