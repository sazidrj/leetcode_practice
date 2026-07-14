class LRUCache {
public:
    class node{
        public:
            int key;
            int value;
            node* next;
            node* prev;

            node(int key, int value){
                this->key = key;
                this->value = value;
        }
    };
    int capacity;
    unordered_map<int, node*> mp;

    node* head = new node(-1,-1);
    node* tail = new node(-1, -1);

    LRUCache(int capacity) {
        this->capacity = capacity;
        head->next = tail;
        tail->prev = head;
    }

    void addNode(node* newNode){
        node* temp = head->next;
        newNode->next = temp;
        head->next = newNode;
        temp->prev = newNode;
        newNode->prev = head;
    }

    void deleteNode(node* delNode){
        node* delNext = delNode->next;
        node* delPrev = delNode->prev;
        delPrev->next = delNext;
        delNext->prev = delPrev;
    }

    int get(int key) {
        if (mp.find(key) != mp.end()){
            node* resNode = mp[key];
            int val = resNode->value;
            mp.erase(key);
            deleteNode(resNode);
            addNode(resNode);
            mp[key] = head->next;
            return val;
        }
           
        return -1;
    }
    
    void put(int key, int value) {
        if(mp.find(key) != mp.end()){
            node* existingNode = mp[key];
            mp.erase(key);
            deleteNode(existingNode);
        }
        if(mp.size() == capacity){
            mp.erase(tail->prev->key);
            deleteNode(tail->prev);
        }

        node* newNode = new node(key, value);
        addNode(newNode);
        mp[key] = head->next;

    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */