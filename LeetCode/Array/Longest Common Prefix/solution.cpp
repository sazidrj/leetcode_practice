class Solution {
public:
    class Node{
        public:
            char data;
            Node* children[26];
            bool isTerminal;
            int childCount;

            Node(char ch){
                data = ch;

                for(int i = 0; i<26; i++){
                    children[i] = NULL;
                }

                isTerminal = false;
                childCount = 0;
            }
    };

    Node* root;

    void insertTrie(string word){
        Node* it = root;

        for(char ch: word){
            if(!it->children[ch-'a']){
                it->children[ch-'a'] = new Node(ch);
                it->childCount += 1;
            }
            it = it->children[ch-'a'];
        }

        it->isTerminal = true;
    }

    string searchTrie(string word){
        Node* it = root;
        string ans = "";

        for(char ch: word){
            if(it->childCount != 1){
                return ans;
            }
            it = it->children[ch-'a'];
            ans += ch;

            if(it->isTerminal == true){
                return ans;
            }
        }

        return ans;
    }

    string longestCommonPrefix(vector<string>& strs) {
        root = new Node('\0');

        for(int i = 0; i<strs.size(); i++){
            if(strs[i].size() == 0) return "";
            insertTrie(strs[i]);
        }

        return searchTrie(strs[0]);

        
    }
};