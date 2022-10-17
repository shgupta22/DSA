package backtracking;

public class NQueen {

    /**
     *
     * Backtracking
     *
     * 1) SolveNQueen(int N, int[][] board, int i) // this will be used for iterating over rows
     * 2) if (i == N) printBoard return true;
     * 3) for (int j = 0; j < N; j++)
     * 4)   if (canPlace(i,j,N,board)
     * 5)       board[i][j] = 1;
     * 6)       success = SolveNQueen(N, board, i+1);
     * 7)       if ( success) return true;
     * 8)       board[i][j] = 0;
     *
     * 9) canPlace(int x, int y, int N, int[][] board)
     *      check in column, check in right diagonal, check in left diagonal
     *
     */

    public static boolean canPlace(int[][] board, int n,int x, int y) {
        // place in column
        for (int i=0; i < x; i++) {
            if(board[i][y] == 1) {
                return false;
            }
        }

        // place in right diag
        int i = x;
        int j = y;
        while (i >= 0 && j < n) {
            if (board[i][j] == 1){
                return false;
            }
            i--;j++;
        }

        //place in left diag
        i = x;
        j = y;
        while (i >=0 && j>=0) {
            if (board[i][j]==1){
                return false;
            }
            i--;j--;
        }
        return true;
    }

    public static void printBoard(int n , int[][] board) {
        for (int i=0; i < n; i++) {
            for(int j=0; j< n; j++) {
                System.out.print(board[i][j]+",");
            }
            System.out.println();
        }
    }

    public static boolean solveNQueen(int n, int[][] board, int i) {
        //base case
        if (i==n) {
            // print board;
            printBoard(n, board);
            return true;
        }


        //recursive case
        for (int j = 0; j < n; j++) {
            if (canPlace(board, n, i, j)) {
                board[i][j] = 1;
                boolean success = solveNQueen(n, board, i+1);
                if (success) {
                    return true;
                }
                //backtrack
                board[i][j]=0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueen(4, new int[4][4], 0));
        System.out.println(solveNQueen(5, new int[5][5], 0));
    }
}
