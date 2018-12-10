class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        buildTrie(this.root, word);
    }
    
    public boolean search(String word) {
        return search(root, 0, word);
    }
    
    public boolean search(TrieNode node, int idx, String word) {
        if(idx == word.length()) {
            return node.exist;
        }
        char ch = word.charAt(idx);
        if(ch == '.') {
            for(int i = 0; i < 26; i++) {
                if(node.next[i] != null) {
                    if(search(node.next[i], idx + 1, word)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if(node.next[ch - 'a'] == null) {
                return false;
            } else {
                return search(node.next[ch - 'a'], idx + 1, word);
            }
        }
    }
    
    private void buildTrie(TrieNode root, String word) {
        for(char ch : word.toCharArray()) {
            if(root.next[ch - 'a'] == null) {
                root.next[ch - 'a'] = new TrieNode();
            }
            root = root.next[ch - 'a'];
        }
        root.exist = true;
    }
}

class TrieNode{
    boolean exist;
    TrieNode[]  next;
    TrieNode(){
        this.exist = false;
        this.next  = new TrieNode[26];
    }
}
