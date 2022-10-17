package backtracking;

public class SolveSudoku {

    /**
     * Backtracking
     *
     * 1) solveSudoku(int i, int j, mat[][], int n)
     * 2) solveSudoku(0,0,mat[][], 9)
     *
     * 3) if ( i == n) we found the solution print
     * 4) if ( j == n) solveSudoku(i+1, 0, mat[][], n) move to next row
     *
     * 5) if ( mat[i][j] != 0) solveSudoku(i, j+1, mat[][], n) if already have a value move to next column
     *
     * 6) for (int k =1; k <= 9; k++)
     *      if (canPlaceValue(i, j, k, mat[][], n)
     *          mat[i][j] = k;
     *          success = solveSudoku(i, j+1, mat[][], n)
     *          if (success) return true;
     *
     * 7) mat[i][j] = 0;
     * 8) return false;
     *
     *
     * canPlaceValue(x, y, no, mat[][], n)
     *
     * for (i= 0; i <9; i++)
     *      if (mat[i][y] == no || mat[x][i] == no)
     *          return false;
     *
     * sx = (x/3)*3;
     * sy = (y/3)*3;
     *
     * for (int i = sx; i < sx+3; i++)
     *      for (j = sy; j < sy+3; j++)
     *          if (mat[i][j] == no) return false;
     *
     * return true;
     *
     *
     */

    public static boolean solveSubProblem(int[][] mat, int i, int j, int no, int n) {
        //row
        //col
        for(int k=0; k<n;k++) {
            if (mat[k][j] == no || mat[i][k] ==no){
                return false;
            }
        }
        //subgrid
        int sx = (i/3)*3;
        int sy = (j/3)*3;
        for (int x =sx; x <sx+3; x++) {
            for(int y=sy; y< sy+3; y++) {
                if (mat[x][y] == no) return false;
            }
        }
        return true;
    }

    public static void printBoard(int n , int[][] mat) {
        for (int i=0; i < n; i++) {
            for(int j=0; j< n; j++) {
                System.out.print(mat[i][j]+",");
            }
            System.out.println();
        }
    }

    public static boolean solveSudoku(int[][] mat, int i, int j, int n) {
        //base case
        if (i == n) {
            //print board
            printBoard(n, mat);
            return true;
        }

        //recursive case
        if (j ==n) {
            return solveSudoku(mat, i+1, 0, n);
        }

        //skip the prefilled value
        if (mat[i][j]!=0) {
            return solveSudoku(mat, i, j+1, n);
        }

        //cell to be filled
        for (int no = 1; no <= 9; no++) {
            //whether it is safe to place  the number
            if (solveSubProblem(mat, i, j, no, n)) {
                mat[i][j] = no;
                boolean success = solveSudoku(mat, i, j + 1, n);
                if (success) {
                    return true;
                }
            }
        }
        //backtracking
        mat[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solveSudoku(new int[][]{
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        }, 0, 0, 9));
    }
}
