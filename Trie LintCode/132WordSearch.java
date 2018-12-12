public class Solution {
    public List<String> wordSearchII(char[][] board, List<String> words) {
        
        List<String> res = new ArrayList();
        if(board.length == 0 || board[0].length == 0) return res;
        
        int m = board.length, n = board[0].length;
        
        TrieNode root = new TrieNode();
        for(String word : words) {
            buildTrie(root, word);
        }
        
        int[] dir = {-1, 0, 1, 0, -1};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(i, j, board, root, res, dir);
            }
        }
        return res;
    }
    
    private void dfs(int x, int y, char[][] board, TrieNode node, List<String> res, int[] dir) {
        char ch = board[x][y];
        TrieNode cur = node;
        if(ch == '#' || cur.next[ch - 'a'] == null) {
            return;
        }
        cur = cur.next[ch - 'a'];
        if(cur.exist) {
            res.add(cur.word);
            cur.exist = false;
        }
        board[x][y] = '#';
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i], ny = y + dir[i + 1];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                dfs(nx, ny, board, cur, res, dir);
            }
        }
        board[x][y] = ch;
    }
    
    private void buildTrie(TrieNode root, String word) {
        for(char ch : word.toCharArray()) {
            if(root.next[ch - 'a'] == null) {
                root.next[ch - 'a'] = new TrieNode();
            }
            root = root.next[ch - 'a'];
        }
        root.word = word;
        root.exist = true;
    }
}

class TrieNode{
    String word;
    boolean exist;
    TrieNode[]  next;
    TrieNode(){
        this.exist = false;
        this.next  = new TrieNode[26];
    }
}