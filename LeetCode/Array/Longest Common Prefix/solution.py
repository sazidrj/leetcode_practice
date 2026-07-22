class Node:
    def __init__(self,ch):
        self.data = ch
        self.children = [None]*26
        self.isTerminal = False
        self.childCount = 0

class Solution:

    def insertTrie(self, word):
        it = self.root

        for ch in word:
            index = ord(ch) - ord('a')

            if it.children[index] is None:
                child = Node(ch)
                it.children[index] = child
                it.childCount += 1
            
            it = it.children[index]
        
        it.isTerminal = True

    def searchTrie(self, word):
        it = self.root
        ans = ""

        for ch in word:
            index = ord(ch) - ord('a')

            if it.childCount != 1:
                return ans
            
            it = it.children[index]
            ans += ch

            if it.isTerminal == True:
                return ans
        
        return ans
            
    
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs:
            return ""

        self.root = Node('/0')

        for word in strs:
            if word == "":
                return ""
            self.insertTrie(word)

        return self.searchTrie(strs[0])
        