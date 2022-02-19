/**
 * 1. Problems:
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * 3. Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
/
class Solution {
    /**
     * 1. Approach:
     * backtrack;DFS;
     *
     * 2. Complexity:
     * Time:O(3^m+4^n)
     * Space:O(m+n)
     * m is the count of number which has three chars and n is the count of number which has four chars.
     *
     * 3. Mistakes & Improvements:
     * this problem can be converted to a DFS problem.
     */
    /
    public List<String> letterCombinations(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        if(digits.length() == 0){
            return combinations;
        }
        HashMap<Character, String> phoneMap = new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        DFS(combinations, phoneMap, new StringBuffer(), digits, 0);
        return combinations;
    }
    private void DFS(List<String> combinations, HashMap<Character, String> phoneMap, StringBuffer combination, String digits, int index){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else{
            char digit = digits.charAt(index);
            String letter = phoneMap.get(digit);
            int letterlength = letter.length();
            for(int i = 0; i < letterlength; i++){
                combination.append(letter.charAt(i));
                DFS(combinations, phoneMap, combination, digits, index+1);
                combination.deleteCharAt(index);
            }
        }
    }
}