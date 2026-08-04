class WordDictionary {
    static class Node{
        char data;
        Node[] children = new Node[26];
        boolean isTerminal;

        Node(char ch){
            this.data = ch;
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            this.isTerminal = false;
        }
    }

    static Node root;

    public WordDictionary() {
        root = new Node('\0');
    }
    
    public void addWord(String word) {
        Node it = root;

        for(char ch: word.toCharArray()){
            if(it.children[ch-'a'] == null){
                it.children[ch-'a'] = new Node(ch);
            }
            it = it.children[ch-'a'];
        }
        it.isTerminal = true;
    }

    public boolean searchHelper(String word, int index, Node cur){
        if(cur == null) return false;
        if(index == word.length()) return cur.isTerminal;

        char ch = word.charAt(index);

        if(ch == '.'){
            for(int i=0; i<26; i++){
                if(cur.children[i] != null && searchHelper(word, index+1, cur.children[i])){
                    return true;
                }
            }
            return false;
        }else{
            if(cur.children[ch - 'a'] == null){
                return false;
            }
            return searchHelper(word, index+1, cur.children[ch-'a']);
        }  
    }
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */