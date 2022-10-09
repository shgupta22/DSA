package binarysearch;

import java.util.Arrays;

public class PairDifferenceIsMinimum {

    public static void findPair(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        //iterate over first array and look for closest element in second array
        int p1 = -1;
        int p2 = -1;
        int diff = Integer.MAX_VALUE;
        for (int x: arr1) {
            int lb = lowerBound(arr2, x);

            //left
            if (lb >= 1 && x -arr2[lb-1] < diff) {
                diff =x - arr2[lb-1];
                p1 = arr2[lb-1];
                p2 = x;
            }

            //right
            if (lb!=arr2.length && arr2[lb]-x < diff) {
                diff = arr2[lb] -x;
                p1 =x;
                p2 = arr2[lb];
            }
        }
        System.out.println("P1: " + p1 + " P2: "+ p2);
    }

    public static int lowerBound(int[] arr, int key) {
        int s =0;
        int e = arr.length -1;
        int ans =0;
        while (s<=e) {
            int mid = (s+e)/2;
            if (arr[mid] <= key) {
                ans = mid;
                s = mid +1;
            } else if (arr[mid] > key) {
                e = mid -1;
            }
        }
        if (ans != 0 && arr[ans] < key) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{4,6,9,10,14,15,17,20}, 9));
        System.out.println(lowerBound(new int[]{4,6,9,10,14,15,17,20}, 11));
        System.out.println(lowerBound(new int[]{4,6,9,10,14,15,17,20}, 16));
        System.out.println(lowerBound(new int[]{4,6,9,10,14,15,17,20}, 2));

        findPair(new int[]{-1,5,10,20,3}, new int[]{26,134,135,15,17});
    }
}
