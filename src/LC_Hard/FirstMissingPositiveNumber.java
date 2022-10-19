package LC_Hard;

import java.util.Map;

public class FirstMissingPositiveNumber {

    /**
        there are 3 approaches
        1) Sort and find the missing number O(nlogn)
        2) Second use HashSet and find the missing number O(n) with space O(n)

        3) Without using extra space, use same array as a hashset O(n)
            - Replace all negative number with 0
            - Iterate over the array
                - Val absolute of A[i], if (val >= 1 && val <= n)
                - if (A[val-1] > 0) A[val-1] *= -1;
                - else if (A[val-1] == 0) A[val-1] = -1*(n+1)

            - for (i=1; i< n+1; i++)
                if (A[i-1] >= 0) return i;

            - return n+1;
     **/
    public static int firstMissingPositiveNumber(int[] A) {
        int n = A.length;
        for (int i=0; i < n; i++) {
            if (A[i] < 0) A[i] = 0;
        }

        for (int i =0; i < n;i++) {
            int val = Math.abs(A[i]);
            if (val >= 1 && val <= n) {
                if (A[val -1] > 0) {
                    A[val-1] *= -1;
                } else if (A[val - 1] == 0) {
                    A[val-1] = -1* (n+1);
                }
            }
        }

        for (int i =1; i < n+1; i++) {
            if (A[i-1] >= 0) return i;
        }
        return n+1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositiveNumber(new int[]{1,2,0}));
    }
}
