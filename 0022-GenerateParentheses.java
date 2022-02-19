/**
 * 1. Problems:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * 3. Constraints:
 *
 * 1 <= n <= 8
 */
/
class Solution {
    /**
     * 1. Approach:
     * backTrack
     *
     * 2. Complexity:
     * Time:O(4^n/sqrt(n))
     * Space:O(n)
     *
     * 3. Mistake & Improvement:
     * the use of StringBuffer.
     */
    /
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuffer(), n, 0);
        return res;
    }
    private void backTrack(List<String> res, StringBuffer cur, int n, int countleft){
        if(n == 0 && countleft == 0){
            res.add(cur.toString());
            return;
        }else{
            if(countleft > 0){
                cur.append(')');
                backTrack(res, cur, n, countleft - 1);
                cur.deleteCharAt(cur.length() - 1);
            }
            if(n > 0){
                cur.append('(');
                backTrack(res, cur, n - 1, countleft + 1);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}