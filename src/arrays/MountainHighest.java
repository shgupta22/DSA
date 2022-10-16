package arrays;

public class MountainHighest {

    /**
     *
     * Peaks are formed when A[i-1] < A[i] and A[i+1] < A[i]
     * if that's true we have one peak, j = i;
     * now, iterate over the left part and counting until j > 0 and A[j-1] < A[j], j--;
     * for right part counting until i < n-2 and A[i+1] < A[i], i++
     *
     * Keep a Max with currentMax
     * Complexity O(2N)
     */

    public static int highestMountain(int[] arr) {
        int n = arr.length;
        int max = 0;
        for (int i =1; i <= n-2;) {
            // check peak
            if (arr[i-1]< arr[i] && arr[i] >arr[i+1]) {
                int currentMax = 1;
                int j = i;

                //count backward
                while (j > 0 && arr[j -1] <arr[j]) {
                    j--;
                    currentMax++;
                }
                while (i < n-2 && arr[i+1] < arr[i]) {
                    i++;
                    currentMax++;
                }
                max = Math.max(currentMax, max);
//                System.out.println(max);
            } else {
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4};
        System.out.println(highestMountain(arr));
    }
}
