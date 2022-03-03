/**
 * 1. Problems:
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * 3. Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 *
 */
/
class Solution {
    /**
     * 1. Approach:
     * Unionfind.
     * 2. Complexity:
     * Time:O((N+Q)logA)
     * Space:O(A)
     * N is the length of equations, Q is the length of queries and A is the length of hashmap.
     */
    /
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationssize = equations.size();
        Map<String, Integer> map = new HashMap<>(2 * equationssize);
        UnionFind unionFind = new UnionFind(2 * equationssize);
        int id = 0;

        for(int i = 0; i < equationssize; i++){
            String val1 = equations.get(i).get(0);
            String val2 = equations.get(i).get(1);

            if(!map.containsKey(val1)){
                map.put(val1, id);
                id++;
            }
            if(!map.containsKey(val2)){
                map.put(val2, id);
                id++;
            }
            unionFind.union(map.get(val1), map.get(val2), values[i]);
        }

        int queriessize = queries.size();
        double[] res = new double[queriessize];
        for(int i = 0; i < queriessize; i++){
            String val1 = queries.get(i).get(0);
            String val2 = queries.get(i).get(1);
            Integer id1 = map.get(val1);
            Integer id2 = map.get(val2);
            if(id1 == null || id2 == null){
                res[i] = -1.0d;
            }else{
                res[i] = unionFind.isConnect(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind{
        private int[] parent;
        private double[] weight;

        public UnionFind(int n){
            parent = new int[n];
            weight = new double[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        private int find(int x){
            if(x != parent[x]){
                int origion = parent[x];
                parent[x] = find(origion);
                weight[x] *= weight[origion];
            }
            return parent[x];
        }

        public void union(int x, int y, double value){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }else{
                parent[rootX] = rootY;
                weight[rootX] = weight[y] * value / weight[x];
            }
        }

        public double isConnect(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return weight[x] / weight[y];
            }else{
                return -1.0d;
            }
        }
    }
}