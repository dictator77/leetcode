/**
 * 1. Problems:
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * 3. Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * HashMap and two pointers.
     * 2. Complexity:
     * Time:O(n + m)
     * Space:O(m)
     */
    /
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        int psize = p.length();
        int ssize = s.length();
        for(int i = 0; i < psize; i++){
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int front = 0;
        int tail = 0;
        while(tail < ssize){
            char a = s.charAt(tail);
            if(pmap.containsKey(a)){
                //System.out.println("a:"+a+",map:"+pmap.get(a));
                pmap.put(a, pmap.get(a) - 1);
                if(pmap.get(a) == 0 && isValid(pmap)){
                    ans.add(front);
                    pmap.put(s.charAt(front), 1);
                    front++;
                }else if(pmap.get(a) < 0){
                    while(pmap.get(a) < 0 && front <= tail){
                        pmap.put(s.charAt(front), pmap.get(s.charAt(front)) + 1);
                        front++;
                    }
                }
            }else{
                while(front < tail){
                    pmap.put(s.charAt(front), pmap.get(s.charAt(front)) + 1);
                    front++;
                }
                front = tail + 1;
            }
            tail++;
            if(front + psize > ssize){
                break;
            }
        }
        return ans;
    }
    private boolean isValid(HashMap<Character, Integer> pmap){
        for(int value: pmap.values()){
            if(value != 0){
                return false;
            }
        }
        return true;
    }
}