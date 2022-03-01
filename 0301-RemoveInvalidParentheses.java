/**
 * 1. Problems:
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 *
 * Return all the possible results. You may return the answer in any order.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * Example 2:
 *
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * Example 3:
 *
 * Input: s = ")("
 * Output: [""]
 *
 * 3. Constraints:
 *
 * 1 <= s.length <= 25
 * s consists of lowercase English letters and parentheses '(' and ')'.
 * There will be at most 20 parentheses in s.
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * BFS
     * 2. Complexity:
     * Time:O(n*2^n)
     * Space:O(n*C(n/2,n))
     */
    /
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        Set<String> currSet = new HashSet<>();
        currSet.add(s);
        while(true){
            for(String str:currSet){
                if(isValid(str)){
                    res.add(str);
                }
            }
            if(res.size() > 0){
                return res;
            }
            Set<String> nextSet = new HashSet<>();
            for(String str:currSet){
                for(int i = 0; i < str.length(); i++){
                    if(i > 0 && str.charAt(i) == str.charAt(i - 1)){
                        continue;
                    }
                    if(str.charAt(i) == '(' || str.charAt(i) == ')'){
                        nextSet.add(str.substring(0,i) + str.substring(i+1));
                    }
                }
            }
            currSet = nextSet;
        }
    }

    private boolean isValid(String s){
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                count++;
            }else if(s.charAt(i) == ')'){
                count--;
                if(count < 0){
                    return false;
                }
            }
        }
        return count == 0;
    }
}

