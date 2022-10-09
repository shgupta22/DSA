package binarysearch;

public class FrequencyCount {

    /*
    Find Frequency Count in a Sorted array
    1) Brute Force is linear search and count
    2) Use Binary Search upperBound - lowerBound will give us the frequency
     */
    public static int frequencyCount(int[] arr, int target) {
        int lowerBound = lowerBound(arr, target);
        int upperBound = upperBound(arr, target);
        System.out.println(lowerBound);
        System.out.println(upperBound);
        return upperBound - lowerBound +1;
    }

    public static int lowerBound(int[] arr, int target) {
        int l = 0;
        int h = arr.length -1;
        int ans = -1;
        while(l <= h) {
            int mid = (l+h)/2;
            if (arr[mid] == target) {
                ans = mid;
                h = mid -1;
            } else if (arr[mid] > target) {
                h = mid -1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int target) {
        int l = 0;
        int h = arr.length -1;
        int ans = -1;
        while (l <=h) {
            int mid = (l+h)/2;
            if (arr[mid] == target) {
                ans = mid;
                l = mid+1;
            } else if (arr[mid] > target) {
                h = mid -1;
            } else {
                l = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(frequencyCount(new int[]{0,0,0,1,1,2,2,3,3,3,3,3,4,4,4,5,5,6,7}, 3));
    }
}
