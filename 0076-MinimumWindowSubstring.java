/**
 * 1. Problems:
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 * 3. Constraints:
 *
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Sliding window
     * 2. Complexity:
     * Time:O(s+t)
     * Space:O(t)
     */
    /
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int count = t.length();
        int start = 0, end = s.length();
        boolean flag = false;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) >= 0){
                    count--;
                }
            }
            right++;
            while(count == 0){
                flag = true;
                System.out.println(count);
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) > 0){
                        count++;
                    }
                }
                if(end - start > right - left){
                    start = left;
                    end = right;
                }
                left++;
            }
        }
        if(!flag) return "";
        return s.substring(start, end);
    }
}