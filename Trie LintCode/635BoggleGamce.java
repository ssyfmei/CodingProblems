public class Solution {
    int maxCnt = 0;
    int[] dir = {-1, 0, 1, 0, -1};
    public int boggleGame(char[][] board, String[] words) {
        if(board==null||board.length==0||board[0].length==0) return 0;
        int m = board.length, n = board[0].length;
        
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(root, root, i, j, 0, board);
            }
        }
        return maxCnt;
    }
    
    private void dfs(TrieNode root, TrieNode cur, int r, int c, int cnt, char[][] board) {
        maxCnt = Math.max(maxCnt, cnt);
        if(board[r][c] == '#' || cur.next[board[r][c] - 'a'] == null) {
            return;
        }
        char ch = board[r][c];
        board[r][c] = '#';
        cur = cur.next[ch - 'a'];
        
        int m = board.length, n = board[0].length;
        if(cur.exist) {
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    dfs(root, root, i, j, cnt + 1, board);
                }
            }
            return; // because a shorter string is always better!!!
        }
        for(int i = 0; i < 4; i++) {
            int nr = r + dir[i];
            int nc = c + dir[i + 1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                dfs(root, cur, nr, nc, cnt, board);
            }
        }
        board[r][c] = ch;
    }
    
    private void buildTrie(TrieNode root, String[] words) {
        for(String word : words) {
            TrieNode cur = root;
            for(char ch : word.toCharArray()) {
                if(cur.next[ch - 'a'] == null){
                    cur.next[ch - 'a'] = new TrieNode();
                }
                cur = cur.next[ch - 'a'];
            }
            cur.word  = word;
            cur.exist = true;
        }   
    }
    private static class TrieNode{
        TrieNode[] next = new TrieNode[26];
        boolean exist;
        String  word;
    }
}
