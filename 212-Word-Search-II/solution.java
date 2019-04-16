class Solution {

    // T: O(n+m)
    // S: O(n)

    private int R, C;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> found = new HashSet();
        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList(found);
        }

        // init Trie
        Trie trie = new Trie();
        for (String w : words) {
            Trie node = trie;
            for (char c : w.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.data = w;
            node.isEnd = true;
        }

        // search
        R = board.length;
        C = board[0].length;
        boolean[][] visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (trie.children[board[r][c] - 'a'] != null) {
                    List<String> wordList = new ArrayList();
                    searchHelper(board, r, c, trie.children[board[r][c] - 'a'], visited, wordList);
                    found.addAll(wordList);
                }
            }
        }
        return new ArrayList(found);
    }

    private void searchHelper(char[][] board, int r, int c, Trie trie, boolean[][] visited, List<String> wordList) {
        if (trie.isEnd) {
            wordList.add(trie.data);
        }
        visited[r][c] = true;
        if (r > 0 && !visited[r - 1][c] && trie.children[board[r - 1][c] - 'a'] != null) {
            searchHelper(board, r - 1, c, trie.children[board[r - 1][c] - 'a'], visited, wordList);
        }
        if (r < R - 1 && !visited[r + 1][c] && trie.children[board[r + 1][c] - 'a'] != null) {
            searchHelper(board, r + 1, c, trie.children[board[r + 1][c] - 'a'], visited, wordList);
        }
        if (c > 0 && !visited[r][c - 1] && trie.children[board[r][c - 1] - 'a'] != null) {
            searchHelper(board, r, c - 1, trie.children[board[r][c - 1] - 'a'], visited, wordList);
        }
        if (c < C - 1 && !visited[r][c + 1] && trie.children[board[r][c + 1] - 'a'] != null) {
            searchHelper(board, r, c + 1, trie.children[board[r][c + 1] - 'a'], visited, wordList);
        }
        visited[r][c] = false;
    }

    class Trie {
        boolean isEnd;
        String data;
        Trie[] children;

        Trie() {
            this.isEnd = false;
            this.children = new Trie[26];
        }
    }
}