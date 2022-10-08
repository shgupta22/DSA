package arrays;

import java.util.Arrays;

public class SubArraySort {
    /**
     * Sort the smallest part of array so that entire array is sorted
     *
     * Approach Sort the duplicate array and compare with original array.
     * O(nlogn)
     *
     * Find Smallest and Largest, then place them in correct position
     */

    private static boolean checkOutOfOrder(int[] arr, int i) {
        int x = arr[i];
        if (i==0) {
            return x>arr[i+1];
        }
        if (i==arr.length-1) {
            return x<arr[i-1];
        }
        return x > arr[i+1] || x < arr[i-1];
    }

    private static int[] findSubArrayIndex(int[] arr) {
        int n = arr.length;

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i=0; i< n-1; i++) {
            if (checkOutOfOrder(arr,i)) {
                smallest = Math.min(smallest, arr[i]);
                largest = Math.max(largest, arr[i]);
            }
        }

        if (smallest == Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }

        int left = 0;
        int right = n-1;
        while (smallest>=arr[left]) {
            left++;
        }
        while (largest<=arr[right]) {
            right--;
        }

        return new int[]{left,right};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,8,6,7,9,10,11};
        //[5,7]
        System.out.println(Arrays.toString(findSubArrayIndex(arr)));
    }
}
