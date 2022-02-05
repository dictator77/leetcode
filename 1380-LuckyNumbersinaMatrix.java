/**
 * 1. Problem:
 * Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 *
 *
 * 2.Examples:
 * Example 1:
 *
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 2:
 *
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 *
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 * Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 *
 *
 * 3. Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 105.
 * All elements in the matrix are distinct.
 */
/

class Solution {
    /**
     * 1. Approach:
     * traversal
     *
     * 2. Complexity:
     * Time:O(mn)
     * Space:O(m)
     *
     */
    /
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < matrix.length; i++){
            int temp = Integer.MAX_VALUE;
            int index = 0;
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] < temp){
                    temp = matrix[i][j];
                    index = j;
                }
            }
            if(map.containsKey(index)){
                map.put(index, Math.max(map.get(index), temp));
            }else{
                map.put(index, temp);
            }
        }
        for(int i = 0; i < matrix[0].length; i++){
            if(!map.containsKey(i)){
                continue;
            }
            list.add(map.get(i));
            for(int j = 0; j < matrix.length; j++){
                if(matrix[j][i] > map.get(i)){
                    list.remove(new Integer(map.get(i)));
                    break;
                }
            }
        }
        return list;
    }
}