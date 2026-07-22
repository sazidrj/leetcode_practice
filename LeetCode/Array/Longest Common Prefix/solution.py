class Node:
    def __init__(self, ch):
        self.data = ch
        self.children = [None]*26
        self.isTerminal = False
        self.childCount = 0

    
class Solution:
    def insertTrie(self, word: str):
        it = self.root

        for ch in word:
            if it.children[ord(ch) - ord('a')] is None:
                it.children[ord(ch) - ord('a')] = Node(ch)
                it.childCount += 1
            it = it.children[ord(ch) - ord('a')]
        
        it.isTerminal = True
    
    def searchTrie(self, word:str):
        it = self.root
        ans = ""

        for ch in word:
            if it.childCount != 1:
                return ans
            
            it = it.children[ord(ch) - ord('a')]
            ans += ch

            if it.isTerminal == True:
                return ans
        
        return ans
            

    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""
        
        self.root = Node('\0')

        for str in strs:
            if not str:
                return ""

            self.insertTrie(str)
        
        return self.searchTrie(strs[0])


        