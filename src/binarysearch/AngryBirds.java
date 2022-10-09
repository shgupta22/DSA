package binarysearch;

import java.util.Arrays;

public class AngryBirds {

    /*
        Birds might not be sorted, so sort them first.

        Take nests and difference between the start and end of Nest as Input Array for Binary Search.

        for each Nest check if we can place a Bird over here?
        canPlaceBird will take O(n) time.

        if yes then this could be possible answer, the last iteration of Binary Search will give us the answer.


     */
    public static int placeBirds(int[] nests, int birds) {
        Arrays.sort(nests);
        int n = nests.length;

        //Binary Search
        int s = 0;
        int e = nests[n - 1] - nests[0];

        int ans = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            boolean canPlace = canPlaceBird(birds, nests, mid);
            if (canPlace) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }

    public static boolean canPlaceBird(int birds, int[] nests, int sep) {
        int bird = 1;
        int lastLocation = nests[0];
        for (int i = 1; i < nests.length; i++) {
            int currentLocation = nests[i];
            if (currentLocation - lastLocation >= sep) {
                bird++;
                lastLocation = currentLocation;

                if (bird == birds) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(placeBirds(new int[]{8, 9, 1, 2, 4}, 3));
        System.out.println(placeBirds(new int[]{8, 9, 1, 2, 4}, 2));
        System.out.println(placeBirds(new int[]{8, 9, 1, 2, 4}, 4));
        System.out.println(placeBirds(new int[]{8, 9, 1, 2, 4}, 5));
        System.out.println(placeBirds(new int[]{8, 9, 1, 2, 4}, 6));
    }
}
