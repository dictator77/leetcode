/**
 * 1. Problems:
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 * 2. Examples:
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 * 3. Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 *
 */
/
class Trie {
    class TreeNode{
        char val;
        boolean end_flag;
        List<TreeNode> next;
        public TreeNode(){};
        public TreeNode(char val){
            this.val = val;
        }
        public TreeNode(char val, ArrayList<TreeNode> next){
            this.val = val;
            this.next = next;
        }
    }
    TreeNode head;

    public Trie() {
        this.head = new TreeNode();
    }

    public void insert(String word) {
        TreeNode temp = head;
        for(int i = 0; i < word.length(); i++){
            boolean flag = false;
            if(temp.next == null){
                temp.next = new ArrayList<TreeNode>();
            }
            for(int j = 0; j < temp.next.size(); j++){
                if(temp.next.get(j).val == word.charAt(i)){
                    flag = true;
                    temp = temp.next.get(j);
                    break;
                }
            }
            if(!flag){
                temp.next.add(new TreeNode(word.charAt(i)));
                temp = temp.next.get(temp.next.size() - 1);
            }
        }
        temp.end_flag = true;
    }

    public boolean search(String word) {
        TreeNode temp = head;
        for(int i = 0; i < word.length(); i++){
            boolean flag = false;
            if(temp.next == null){
                return false;
            }
            for(int j = 0; j < temp.next.size(); j++){
                if(temp.next.get(j).val == word.charAt(i)){
                    flag = true;
                    temp = temp.next.get(j);
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return temp.end_flag;
    }

    public boolean startsWith(String prefix) {
        TreeNode temp = head;
        for(int i = 0; i < prefix.length(); i++){
            boolean flag = false;
            if(temp.next == null){
                return false;
            }
            for(int j = 0; j < temp.next.size(); j++){
                if(temp.next.get(j).val == prefix.charAt(i)){
                    flag = true;
                    temp = temp.next.get(j);
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */