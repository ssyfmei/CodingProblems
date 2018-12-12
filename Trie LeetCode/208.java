class Trie {
    static class TrieNode{
        boolean exist;
        TrieNode[] next;
        TrieNode(){
            this.exist = false;
            this.next  = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode root = this.root;
        for(char ch : word.toCharArray()) {
            if(root.next[ch - 'a'] == null) {
                root.next[ch - 'a'] = new TrieNode();
            }
            root = root.next[ch - 'a'];
        }
        root.exist = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = this.root;
        for(char ch : word.toCharArray()) {
            if(cur.next[ch - 'a'] == null) {
                return false;
            }
            cur = cur.next[ch - 'a'];
        }
        return cur.exist;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for(char ch : prefix.toCharArray()) {
            if(cur.next[ch - 'a'] == null) {
                return false;
            }
            cur = cur.next[ch - 'a'];
        }
        return true;
    }
}
