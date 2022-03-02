/**
 * 1. Problems:
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 * 3. Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Stack and stringbuffer
     * 2. Complexity:
     * Time:O(S)
     * Space:O(S)
     */
    /
    public String decodeString(String s) {
        StringBuffer res = new StringBuffer();
        Deque<String> stack = new LinkedList<>();
        for(int i = 0; i < s.length(); ){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                StringBuffer sbdigit = new StringBuffer();
                while(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    sbdigit.append(s.charAt(i));
                    i++;
                }
                stack.offerLast(sbdigit.toString());
            }else if(s.charAt(i) == '['){
                stack.offerLast("[");
                i++;
            }else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                StringBuffer sbletter = new StringBuffer();
                while( i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                    sbletter.append(s.charAt(i));
                    i++;
                }
                stack.offerLast(sbletter.toString());
            }else{
                StringBuffer temp = new StringBuffer();
                while(!stack.peekLast().equals("[")){
                    temp.insert(0, stack.peekLast());
                    stack.pollLast();
                }
                stack.pollLast();
                int num = Integer.valueOf(stack.peekLast());
                stack.pollLast();
                StringBuffer temp1 = new StringBuffer();
                while(num > 0){
                    temp1.append(temp);
                    num--;
                }
                stack.offerLast(temp1.toString());
                i++;
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.peekFirst());
            stack.pollFirst();
        }
        return res.toString();
    }
}