/**
 * 1. Problems:
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * 3. Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
/
class Solution {
    /**
     * 1. Approach:
     * enumerate
     * 2. Complexity:
     * Time:O(n^2)
     * Space:O(n)
     */
    /
    public int countSubstrings(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        boolean[] flag = new boolean[26];
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(s.charAt(i), k -> new LinkedList<>()).add(i);
        }
        for(int k = 0; k < n; k++){
            char temp = s.charAt(k);
            if(!flag[temp - 'a']){
                flag[temp - 'a'] = true;
                List<Integer> templist = map.get(temp);
                int templistsize = templist.size();
                for(int i = 0; i < templistsize; i++){
                    for(int j = i; j < templistsize; j++){
                        int left = templist.get(i);
                        int right = templist.get(j);
                        while(left < right){
                            if(s.charAt(left) == s.charAt(right)){
                                left++;
                                right--;
                            }else{
                                break;
                            }
                        }
                        if(left >= right){
                            //System.out.println("i:"+i+",j:"+j+",temp:"+temp);
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}