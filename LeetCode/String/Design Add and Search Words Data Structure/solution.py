class Node:
    def __init__(self, ch):
        self.data = ch
        self.children = [None]*26
        self.isTerminal = False
    
class WordDictionary:
    def __init__(self):
        self.root = Node('\0')
        

    def addWord(self, word: str) -> None:
        it = self.root

        for ch in word:
            if not it.children[ord(ch) - ord('a')]:
                it.children[ord(ch) - ord('a')] = Node(ch)
                
            it = it.children[ord(ch) - ord('a')]
        
        it.isTerminal = True
    
    def searchHelper(self, word:str, index:int, cur:Node) -> bool:
        if not cur:
            return False
        if index == len(word):
            return cur.isTerminal

        ch = word[index]

        if ch == '.':
            for i in range(26):
                if cur.children[i] and self.searchHelper(word, index+1, cur.children[i]):
                    return True
            return False
        else:
            if not cur.children[ord(ch) -  ord('a')]:
                return False
            return self.searchHelper(word, index+1, cur.children[ord(ch) - ord('a')])   
        

    def search(self, word: str) -> bool:
        return self.searchHelper(word, 0, self.root)
        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)