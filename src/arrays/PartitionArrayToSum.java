package arrays;

public class PartitionArrayToSum {

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;

        int sum = 0;
        for (int n: nums) sum += n;

        if (sum%2 != 0) return false;

        sum /= 2;

        Boolean[][] mem = new Boolean[nums.length+1][sum+1];

        return subSetsSum(nums, mem, 0, sum);
    }

    public static boolean subSetsSum(int[] nums, Boolean[][] mem, int pos, int sum) {
        if (sum == 0) return true;
        if (pos >= nums.length || sum <= 0) return false;

        if (mem[pos][sum] != null) return mem[pos][sum];

        return mem[pos][sum] = subSetsSum(nums, mem, pos+1, sum-nums[pos]) ||
                subSetsSum(nums, mem, pos+1, sum);
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
}
