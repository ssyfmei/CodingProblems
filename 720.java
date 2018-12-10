class TrieNode{
    boolean exist;
    TrieNode[] next;
    TrieNode(){
        this.exist = false;
        this.next  = new TrieNode[26];
    }
}

class Solution {
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        contructTrie(root, words);
        
        String res = null;
        for(String word : words) {
            TrieNode cur = root;
            for(char ch : word.toCharArray()) {
                if(cur.next[ch - 'a'] == null) break;
                cur = cur.next[ch - 'a'];
                if(!cur.exist) break;
            }
            if(cur != null && cur.exist) {
                res = updateRes(res, word);
            }
        }
        return (res == null)?"":res;
    }
    
    private String updateRes(String res, String word) {
        if(res == null) {
            res = word;
        } else if(res.length() < word.length()) {
            res = word;
        } else if(res.length() == word.length() && word.compareTo(res) < 0) {
            res = word;
        }
        return res;
    }
    
    private void contructTrie(TrieNode root, String[] words) {
        for(String word : words) {
            TrieNode cur = root;
            for(char ch : word.toCharArray()) {
                if(cur.next[ch - 'a'] == null) {
                    cur.next[ch - 'a'] = new TrieNode();
                }
                cur = cur.next[ch - 'a'];
            }
            cur.exist = true;
        }
    }
}
