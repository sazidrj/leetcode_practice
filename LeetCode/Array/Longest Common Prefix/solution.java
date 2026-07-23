class Solution {
    static class Node{
        char data;
        Node[] children = new Node[26];
        boolean isTerminal;
        int childCount;

        Node(char ch){
            this.data = ch;
            for(int i = 0; i<26; i++){
                children[i] = null;
            }

            this.isTerminal = false;
            this.childCount = 0;
        }
    }

    static Node root;

    public static void insertTrie(String word){
        Node it = root;

        for(char ch: word.toCharArray()){
            if(it.children[ch-'a'] == null){
                it.children[ch-'a'] = new Node(ch);
                it.childCount++;
            }
            it = it.children[ch-'a'];
        }

        it.isTerminal = true;
    }

    public static String searchTrie(String word){
        Node it = root;
        StringBuilder stb = new StringBuilder();
        for(char ch: word.toCharArray()){
            if(it.childCount != 1){
                return stb.toString();
            }

            it = it.children[ch-'a'];
            stb.append(ch);
            
            if(it.isTerminal == true){
                return stb.toString();
            }

            
        }
        return stb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        root = new Node('\0');

        for(int i = 0; i<strs.length; i++){
            if(strs[i].length() == 0){
                return "";
            }
            insertTrie(strs[i]);
        }

        return searchTrie(strs[0]);
    }
}