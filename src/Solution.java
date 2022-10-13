class Solution {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        for (int i=0;i<nums.length;i++) dp[i] = 1;
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1+ dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,3,4}));
    }
}