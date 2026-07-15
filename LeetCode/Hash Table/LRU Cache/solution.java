class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.next = null;
        }
    }

    private int capacity;
    HashMap<Integer, Node> hm;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();
    }

    

    void addNode(Node newNode){
       Node temp = head.next;

       newNode.next = temp;
       newNode.prev = head;
       head.next = newNode;
       temp.prev = newNode;
    }

   
    void deleteNode(Node delNode){
        Node nodeNext = delNode.next;
        Node nodePrev = delNode.prev;
        nodeNext.prev = nodePrev;
        nodePrev.next = nodeNext;
    }

    
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node resNode = hm.get(key);
            int val = resNode.val;
            deleteNode(resNode);
            addNode(resNode);
            hm.put(key, head.next);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            hm.remove(key);
            deleteNode(temp);
        }

        if(hm.size() == capacity){
            hm.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        hm.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */