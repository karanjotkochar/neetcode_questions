import java.util.*;

public class q14_validSudoku {
    public static void main(String[] args) {
        char[][] board = {
                            {'1','2','.','.','3','.','.','.','.'},
                            {'4','.','.','5','.','.','.','.','.'},
                            {'.','9','8','.','.','.','.','.','3'},
                            {'5','.','.','.','6','.','.','.','4'},
                            {'.','.','.','8','.','3','.','.','5'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','.','.','.','.','.','2','.','.'},
                            {'.','.','.','4','1','9','.','.','8'},
                            {'.','.','.','.','8','.','.','7','9'}
                        };
        isValidSudoku(board);
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        // brute force method
        // time = O(n*n) and space = O(n)

        // for rows
        for (int row = 0; row < 9; row++) {
            Set<Character> testSet = new HashSet<>();
            for (int i=0; i < 9 ; i++) {
                if (board[row][i] == '.')
                    continue;
                if (testSet.contains(board[row][i]))
                    return false;

                testSet.add(board[row][i]);
            }
        }

        // for columns
        for (int col = 0; col < 9; col++) {
            Set<Character> testSet = new HashSet<>();
            for (int i=0; i < 9 ; i++) {
                if (board[i][col] == '.')
                    continue;
                if (testSet.contains(board[i][col]))
                    return false;

                testSet.add(board[i][col]);
            }
        }

        // for sub-box
        for (int square = 0; square < 9; square++) {
            Set<Character> testSet = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    // ** IMPORTANT:
                    // 0 1 2
                    // 3 4 5
                    // 6 7 8
                    // i and j iterate inside the 3*3 grid
                    int row = (square/3)*3 + i;
                    int col = (square%3)*3 + j;

                    if (board[row][col] == '.')
                        continue;
                    if (testSet.contains(board[row][col]))
                        return false;

                    testSet.add(board[row][col]);
                }
            }
        }

        return true;
    }

    // method 2's:
    // Using HashSet -- time = o(n*n)
    // Using Bitmask -- time = o(n*n)
}
