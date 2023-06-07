/*
Time complexity - O(n!*n) 
Space Complexity - O(n2)
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < List < String >> ();
        dfs(0, board, res);
        return res;
    }

    static boolean validate(char[][] board, int row, int col) {
        //check for element in top left diagnol
        for (int i = row, j= col; i>=0 && j >=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //check for element in bottom left diagnol
        for (int i = row, j= col; i< board.length && j >=0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //check for element in left in same row
        for (int j= col; j >= 0; j--) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    static void dfs(int col, char[][] board, List < List < String >> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    static List < String > construct(char[][] board) {
        List < String > res = new ArrayList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }    
}