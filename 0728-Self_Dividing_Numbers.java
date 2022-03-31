/**
 * 1. Problems:
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * A self-dividing number is not allowed to contain the digit zero.
 *
 * Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: left = 1, right = 22
 * Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
 * Example 2:
 *
 * Input: left = 47, right = 85
 * Output: [48,55,66,77]
 *
 *
 * 3. Constraints:
 *
 * 1 <= left <= right <= 104
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * directly judge every number between left and right.
     *
     * 2. Complexity:
     * Time: O(n*log right)
     * Space: O(1)
     */
    /
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new LinkedList<>();
        for(int i = left; i <= right; i++){
            if(isDivide(i)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean isDivide(int x){
        int tempx = x;
        while(tempx > 0){
            int temp = tempx % 10;
            tempx /= 10;
            if(temp == 0 || x % temp != 0){
                return false;
            }
        }
        return true;
    }
}