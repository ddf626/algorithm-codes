package ddf.p12_backtrace;

/**
 * <a href="https://leetcode.cn/problems/word-search">leetcode 79.单词搜索</a>
 */
public class C64_WordSearch {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] used = new boolean[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (backtrack(board, used, 0, word, i, j, m, n)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] used, int index, String word, int i, int j, int m, int n) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if (used[i][j]) {
            return false;
        }

        if (word.charAt(index) != board[i][j]) {
            return false;
        }

        used[i][j] = true;
        boolean ok = backtrack(board, used, index + 1, word, i - 1, j, m, n)
                || backtrack(board, used, index + 1, word, i, j - 1, m, n)
                || backtrack(board, used, index + 1, word, i + 1, j, m, n)
                || backtrack(board, used, index + 1, word, i, j + 1, m, n);

        used[i][j] = false;

        return ok;
    }

    public static void main(String[] args) {
        C64_WordSearch s = new C64_WordSearch();

        // board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
        char[][] board = new char[3][4];

        board[0] = new char[] {'A', 'B', 'C', 'E'};
        board[1] = new char[] {'S', 'F', 'C', 'S'};
        board[2] = new char[] {'A', 'D', 'E', 'E'};

        // board = [["a", "b"], ["c", "d"]], word = "abcd"
//        char[][] board = new char[2][2];
//
//        board[0] = new char[] {'a', 'b'};
//        board[1] = new char[] {'c', 'd'};

        System.out.println(s.exist(board, "SEE"));
    }

}
