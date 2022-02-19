/**
 * 1. Problems:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * 3. Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
/
class Solution {
    /**
     * 1. Approach:
     * use a stack
     *
     * 2. Complexity:
     * Time:O(n)
     * Space:O(n)
     */
    /
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        int length = s.length();
        for(int i = 0; i < length; i++){
            char temp = s.charAt(i);
            if(temp == '(' || temp == '[' || temp == '{'){
                stack.addLast(temp);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(temp == ')'){
                    if(stack.peekLast() == '('){
                        stack.pollLast();
                    }else{
                        return false;
                    }
                }else if(temp == ']'){
                    if(stack.peekLast() == '['){
                        stack.pollLast();
                    }else{
                        return false;
                    }
                }else if(temp == '}'){
                    if(stack.peekLast() == '{'){
                        stack.pollLast();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}