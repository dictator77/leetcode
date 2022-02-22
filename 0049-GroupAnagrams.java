/**
 * 1. Problems:
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * 3. Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
/
class Solution {
    /**
     * 1. Approach:
     * Hashmap to record.
     *
     * 2. Complexity:
     * Tima:O(n*(k+|Σ|))
     * Space:O(n*(k+|Σ|))
     */
    /
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(int i = 0; i < str.length(); i++){
                count[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < count.length; i++){
                if(count[i] != 0){
                    sb.append('a'+i);
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}