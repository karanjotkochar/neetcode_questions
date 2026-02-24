public class q73_WordSearch {

    private static int ROWS, COLS;
    private static boolean[][] visited;

    public static void main(String[] args) {
        char[][] board = {
                            {'A', 'B', 'C', 'D'},
                            {'S', 'A', 'A', 'T'},
                            {'A', 'C', 'A', 'E'}
                        };
        String word = "CAT";
        exist(board, word);
    }
    public static boolean exist(char[][] board, String word) {
        // Using Recursive Backtracking + DFS
        // TC = O(n.m.4^n)
        // SC = O(n)

        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int r, int c, int i) {

        if (i == word.length()) {                                   // i == word length --> found the word
            return true;
        }

        if (r<0 || c<0 || r>=ROWS || c>=COLS || board[r][c] != word.charAt(i) || visited[r][c]) {           // Revisiting visited[r][c] avoids same cell in current path
            return false;
        }

        visited[r][c] = true;                                       // choose --> explore --> un-choose
        boolean res = dfs(board, word, r+1, c, i+1) ||
                        dfs(board, word, r-1, c, i+1) ||
                        dfs(board, word, r, c+1, i+1) ||
                        dfs(board, word, r, c-1, i+1);
        visited[r][c] = false;

        return res;
    }
}