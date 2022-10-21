import java.util.Arrays;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];

        dfs(image, sr, sc, color, initColor);
        return image;
    }

    public static void dfs(int[][] image, int r, int c, int color, int initColor) {
        if (r < 0 || r > image.length-1 || c < 0|| c > image[0].length-1) return;

        if (image[r][c] != initColor) {
            return;
        }

        if (image[r][c] == color) return;

        image[r][c] = color;

        dfs(image, r-1, c, color, initColor);
        dfs(image, r+1, c, color, initColor);
        dfs(image, r, c-1, color, initColor);
        dfs(image, r, c+1, color, initColor);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        }, 1, 1, 2)));

        //[[2,2,2],[2,2,0],[2,0,1]]
    }
}
