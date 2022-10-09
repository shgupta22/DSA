package binarysearch;

public class DivideAmongFriends {

    public static int divideAmongFriend(int[] coins, int k) {
        int s = 0;
        int e = 0;
        for (int c: coins) e+=c;

        int ans =0;
        while(s<=e) {
            int mid = (s+e)/2;
            boolean isPossible = divideAmongk(coins, k, mid);
            if (isPossible) {
                s = mid+1;
                ans = mid;
            } else {
                e = mid -1;
            }
        }
        return ans;
    }

    public static boolean divideAmongk(int[] coins, int k, int minCoins) {
        int partition = 0;
        int currFriend = 0;

        for (int coin : coins) {
            if (currFriend + coin >= minCoins) {
                partition++;
                currFriend = 0;
            } else {
                currFriend += coin;
            }
        }
        return partition >= k;
    }

    public static void main(String[] args) {
        System.out.println(divideAmongFriend(new int[]{1,2,3,4}, 3));
        System.out.println(divideAmongFriend(new int[]{10,20,30,40}, 3));
        System.out.println(divideAmongFriend(new int[]{12,20,35,40,50}, 3));
    }
}
