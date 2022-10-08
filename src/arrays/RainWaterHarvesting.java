package arrays;

public class RainWaterHarvesting {
    /**
     * Create Left and Right with maximum height
     *
     * then calculate water[i] = Min(Left[i], Right[i]) - Height[i];
     *
     * Complexity O(N+N+N) = O(N)
     */

    private static int totalWater(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        //Left Max, Right Max
        int[] left = new int[n];
        int[] right = new int[n];

        //Fill Left Max
        //Fill Right Max
        left[0] = height[0];
        right[n-1] = height[n-1];
        for(int i =1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
            right[n-i-1] = Math.max(right[n-i], height[n-i-1]);
        }

        /*for (int i = n-2; i >=0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }*/

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - height[i];
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(totalWater(arr));
    }


}
