
class WordDictionary {
public:
    class Node{
        public:
            char data;
            Node* children[26];
            bool isTerminal;
            
            Node(char ch){
                data = ch;

                for(int i = 0; i<26; i++){
                    children[i] = NULL;
                }

                isTerminal = false;
            }
    };
    Node* root;

    WordDictionary() {
        root = new Node('\0');
    }
    
    void addWord(string word) {
        Node* it = root;

        for(char ch: word){
            if(!it->children[ch-'a']){
                it->children[ch-'a'] = new Node(ch);
            }
            it = it->children[ch-'a'];
        }

        it->isTerminal = true;
    }

    // Helper function for recursive search with wildcard matching
    bool searchInNode(string& word, int index, Node* curr) {
        if (!curr) return false;
        if (index == word.length()) return curr->isTerminal;

        char ch = word[index];

        if (ch == '.') {
            // Try all possible valid child nodes for wildcard matching
            for (int i = 0; i < 26; i++) {
                if (curr->children[i] && searchInNode(word, index + 1, curr->children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            // Standard lookup for lowercase letters
            int childIndex = ch - 'a';
            if (!curr->children[childIndex]) {
                return false;
            }
            return searchInNode(word, index + 1, curr->children[childIndex]);
        }
    }

    bool search(string word) {
        return searchInNode(word, 0, root);
    }
};

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */