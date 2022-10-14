package LC_Hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();

        for (int r =0; r < board.length; r++) {
            for (int c=0; c< board[0].length; c++) {
                char c1 = board[r][c];
                if (c1 == '.') continue;

                if (!rows.containsKey(r)) rows.put(r, new HashSet<>());
                if (!cols.containsKey(c)) cols.put(c, new HashSet<>());
                if (!square.containsKey((r/3+","+c/3))) square.put((r/3+","+c/3), new HashSet<>());
                if (rows.get(r).contains(c1) || cols.get(c).contains(c1) || square.get((r/3+","+c/3)).contains(c1)) return false;

                rows.get(r).add(c1);
                cols.get(c).add(c1);
                square.get((r/3+","+c/3)).add(c1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}));

        System.out.println(isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}));
    }
}
