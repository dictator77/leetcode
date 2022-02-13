/**
 * 1. Problems:
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * 3. Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
/

class Solution {
    /**
     * 1. Approach:
     * Two Pointers
     * 2. Complexity:
     * Time:O(n+m+|Σ|)
     * Space:O(|Σ|)
     */
    /
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        if(s1.length() > s2.length()){
            return false;
        }
        for(int i = 0; i < s1.length(); i++){
            ++cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for(int right = 0; right < s2.length(); right++){
            int x = s2.charAt(right) - 'a';
            cnt[x]--;
            while(cnt[x] < 0){
                cnt[s2.charAt(left) - 'a']++;
                left++;
            }
            if(right - left + 1 == s1.length()){
                return true;
            }
        }
        return false;
    }
}