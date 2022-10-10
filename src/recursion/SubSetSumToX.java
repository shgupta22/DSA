package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSetSumToX {

    public static int findNumOfWay(int[] arr, int n, int i, int x) {
        if (i == n) {
            if (x == 0) return 1;
            else return 0;
        }

        int inc = findNumOfWay(arr, n, i+1, x -arr[i]);
        int exc = findNumOfWay(arr, n, i+1, x);
        return inc + exc;
    }

    public static void main(String[] args) {
        System.out.println(findNumOfWay(new int[]{1,2,3,4,5,6}, 6, 0, 6));
    }
}
