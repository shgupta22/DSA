package slidingwindow;

import java.util.Arrays;

public class HousingLand {
    /*
        Find SubArray equal to sum

        1) Brute force O(n3)
        2) Using PrefixSum O(n2)
        3) Using PrefixSum and BinarySearch  O(nlogn)
        4) Using Sliding Window
     */


    public static void prefixSum(int[] lands, int target) {
        int n = lands.length;
        int[] prefix = new int[n];
        prefix[0] = lands[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + lands[i];
        }
        //prefixSum(new int[]{1,3,2,1,4,1,3,2,1,1,2}, 8);
        //                    0,1,2,3,4,5,6,7,8,9,10
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (prefix[j] - prefix[i - 1] == target) {
                    System.out.println(i + "," + j);
                }
            }
        }
    }

    public static void prefixSumBinarySearch(int[] lands, int target) {
        int n = lands.length;
        int[] prefix = new int[n];
        prefix[0] = lands[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + lands[i];
        }

        System.out.println(Arrays.toString(prefix));
        for (int i = 1; i < n; i++) {
            int l = i - 1;
            int h = n - 1;
            while (l < h) {
                int mid = (l + h) / 2;
                int i1 = prefix[mid] - prefix[i - 1];
                if (i1 == target) {
                    System.out.println(i + "," + mid);
                    break;
                } else if (i1 - target < 0) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
    }

    public static void housingLand(int[] A, int target) {

        int i = 0;
        int j = 0;
        int n = A.length;
        int sum = 0;
        while (j < n) {
            //expand to right
            sum += A[j];
            j++;

            // remove element from left till sum > target and i < j
            while (sum > target && i < j) {
                sum -= A[i];
                i++;
            }

            // check is sum == target
            if (sum == target) {
                System.out.println(i + "," + (j - 1));
            }
        }
    }


    public static void main(String[] args) {
        prefixSum(new int[]{1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2}, 8);
        //                  0,1,2,3,4,5,6,7,8,9,10
        System.out.println("*****");
        prefixSumBinarySearch(new int[]{1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2}, 8);
        //                              0,1,2,3,4,5,6,7,8,9,10
        //                             [1,4,6,7,11,12,15,17,18,19,21]

        System.out.println("*****");
        housingLand(new int[]{1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2}, 8);
    }
}
