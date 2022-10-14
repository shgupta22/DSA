package backtracking;

public class NQueen {

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
