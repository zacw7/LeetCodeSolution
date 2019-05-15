class Solution {
    // T: O(n+m)
    // S: O(n)
    int R, C;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> found = new HashSet();
        TrieNode trie = new TrieNode();
        // construct trie
        for (String w : words) {
            TrieNode node = trie;
            for (char c : w.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
            node.word = w;
        }
        // search word in board
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return new ArrayList(found);
        }
        R = board.length;
        C = board[0].length;
        boolean[][] visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                search(board, trie, r, c, visited, found);
            }
        }
        return new ArrayList(found);
    }

    private void search(char[][] board, TrieNode node, int r0, int c0,
                        boolean[][] visited, Set<String> found) {
        char ch = board[r0][c0];
        if (node.children[ch - 'a'] == null) {
            return;
        } else {
            node = node.children[ch - 'a'];
        }
        if (node.isEnd) {
            found.add(node.word);
        }
        visited[r0][c0] = true;
        for (int[] d : directions) {
            int r = r0 + d[0], c = c0 + d[1];
            if (r >= 0 && r < R && c >= 0 && c < C && !visited[r][c]) {
                search(board, node, r, c, visited, found);
            }
        }
        visited[r0][c0] = false;
    }

    class TrieNode {
        String word;
        boolean isEnd;
        TrieNode[] children;

        TrieNode() {
            this.word = null;
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
}