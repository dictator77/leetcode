/**
 * 1. Problems:
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 * 2. Examples:
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * 3. Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 *
 */
/
class LRUCache {
    /**
     * 1. Approach:
     * DLinkedNode and hashmap
     *
     * 2. Complexity:
     * Time:O(1)
     * Space:O(1)
     */
    /
    class DLinkedNode{
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private int size;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            DLinkedNode temp = cache.get(key);
            moveToHead(temp.key);
            return temp.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).val = value;
            moveToHead(key);
        }else if(size == capacity){
            removeDLinkedNode();
            addDLinkedNode(key, value);
        }else{
            addDLinkedNode(key, value);
        }
    }

    private void moveToHead(int key){
        DLinkedNode temp = cache.get(key);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = head;
        head.next.prev = temp;
        temp.next = head.next;
        head.next = temp;
    }

    private void addDLinkedNode(int key, int value){
        DLinkedNode temp = new DLinkedNode(key, value);
        temp.prev = head;
        head.next.prev = temp;
        temp.next = head.next;
        head.next = temp;
        cache.put(key, temp);
        this.size++;
    }

    private void removeDLinkedNode(){
        DLinkedNode temp = tail.prev;
        tail.prev = temp.prev;
        temp.prev.next = tail;
        cache.remove(temp.key);
        this.size--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */