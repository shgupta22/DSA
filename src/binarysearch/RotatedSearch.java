package binarysearch;

public class RotatedSearch {

    /*
        Find in rotated array

        there will be 2 cases

        first sorted part

        second sorted part

        if mid lie in first sorted part
            the array will be sorted from Start to Mid
                - check if Key is in between Arr[Start] and Arr[Mid]
                    - if yes End = Mid -1;
                    - else Start = Mid +1;

        if mid lie in second sorted part
            the array will be sorted from Mid to End
                - check if Key is in between Arr[Mid] and Arr[End]
                    - if yes Start = Mid +1;
                    - else End = Mid -1;

     */
    public static int findInRotatedArray(int[] arr, int target) {
        int n = arr.length;
        int s = 0;
        int e = n -1;

        while (s <= e) {
            int mid = (s+e)/2;
            if (arr[mid] == target) {
                return mid;
            }
            //2 cases
            if (arr[s] <= arr[mid]) {
                //left
                if (target>= arr[s] && target <= arr[mid]) {
                    e = mid -1;
                } else  {
                    s = mid+1;
                }
            } else {
                //right

                if (target <= arr[e] && target >= arr[mid]) {
                    s = mid +1;
                } else {
                    e = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findInRotatedArray(new int[]{4,5,6,7,8,0,1,2,3}, 7));
        System.out.println(findInRotatedArray(new int[]{4,5,6,7,8,0,1,2,3}, 2));
        System.out.println(findInRotatedArray(new int[]{4,5,6,7,8,0,1,2,3}, 0));
        System.out.println(findInRotatedArray(new int[]{4,5,6,7,8,0,1,2,3}, 9));
    }
}
