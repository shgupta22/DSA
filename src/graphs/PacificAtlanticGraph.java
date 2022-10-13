package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticGraph {

    static int ROWS;
    static int COLS;
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        Set<String> pac = new HashSet<>();
        Set<String> atl = new HashSet<>();

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights[0][c], heights);
            dfs(ROWS-1, c, atl, heights[ROWS-1][c], heights);
        }

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights[r][0], heights);
            dfs(r, COLS-1, atl, heights[r][COLS-1], heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c =0; c< COLS; c++) {
                if (pac.contains(r+","+c) && atl.contains(r+","+c)) {
                    res.add(List.of(r, c));
                }
            }
        }
        return res;
    }

    public static void dfs(int r, int c, Set<String> visited, int prevHeight, int[][] heights) {
        if (r < 0 || c<0 || r == ROWS || c == COLS) return;
        if (visited.contains(r+","+c)) return;
        if (heights[r][c] < prevHeight) return;
        visited.add(r+","+c);
        dfs(r+1,c,visited,heights[r][c], heights);
        dfs(r-1,c,visited,heights[r][c], heights);
        dfs(r,c+1,visited,heights[r][c], heights);
        dfs(r,c-1,visited,heights[r][c], heights);
    }

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        }));
    }
}
