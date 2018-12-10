public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            buildTrie(root, word);
        }
        List<List<String>> res = new ArrayList();
        List<String> list = new ArrayList();
        for(String word : words) {
            list.add(word);
            dfs(word.length(), root, res, list);
            list.remove(list.size() - 1);
        }
        return res;
    }
    
    private void dfs(int n, TrieNode root, List<List<String>> res, List<String> list) {
        int idx = list.size();
        if(idx == n) {
            res.add(new ArrayList(list));
            return;
        }
        TrieNode cur = root;
        for(String onlist : list) {
            char ch = onlist.charAt(idx);
            if(cur.next[ch - 'a'] == null){
                return;
            }
            cur = cur.next[ch - 'a'];
        }
        for(String str : cur.startsWith){
            list.add(str);
            dfs(n, root, res, list);   // ROOT BUG!!!
            list.remove(list.size() - 1);
        }
    }
    
    private void buildTrie(TrieNode root, String word) {
        for(char ch : word.toCharArray()) {
            if(root.next[ch - 'a'] == null) {
                root.next[ch - 'a'] = new TrieNode();
            }
            root = root.next[ch - 'a'];
            root.startsWith.add(word);
        }
        root.exist = true;
    }
}

class TrieNode{
    List<String> startsWith;
    boolean exist;
    TrieNode[]  next;
    TrieNode(){
        this.exist = false;
        this.next  = new TrieNode[26];
        this.startsWith = new ArrayList();
    }
}
