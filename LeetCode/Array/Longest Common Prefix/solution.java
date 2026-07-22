class Solution {
    class Node{
        char data;
        Node children[] = new Node[26];
        boolean isTerminal = false;
        int childCount = 0;

        Node(char ch){
            data = ch;
            for(int i = 0; i<26; i++){
                children[i] = null;
            }
            isTerminal = false;
            childCount = 0;
        }
    }

    Node root;

    void insertTrie(String word){
        Node it = root;

        for(char ch: word.toCharArray()){
            int index = ch - 'a';

            if(it.children[index] == null){
                Node child = new Node(ch);
                it.children[index] = child;
                it.childCount++;
            }
            it = it.children[index];
        }

        it.isTerminal = true;
    }

    String searchTrie(String word){
        Node it = root;
        StringBuilder ans = new StringBuilder();

        for (char ch: word.toCharArray()){
            int index = ch - 'a';

            if(it.childCount != 1){
                return ans.toString();
            }
            it = it.children[index];
            ans.append(ch);

            if(it.isTerminal == true){
                return ans.toString();
            }
        }

        return ans.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        root = new Node('\0');

        for(String word: strs){
            if (word.equals("")) return "";
            insertTrie(word);
        }

        return searchTrie(strs[0]);
    }
}