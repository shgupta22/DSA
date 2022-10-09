package binarysearch;

public class FindSquareRootOfNumber {


    public static double findSquareRoot(int n, int p) {
        int s = 0;
        int e = n;

        double ans = -1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (mid*mid == n) {
                return mid;
            } else if (mid*mid > n) {
                e = mid -1;
            } else {
                ans = mid;
                s = mid+1;
            }
        }
        System.out.println("Integer Part : " + ans);

        // Linear search for each place

        double inc = 0.1;
        for (int i=1; i <= p; i++) {

            while(ans*ans <= n) {
                ans += inc;
            }
            ans = ans -inc;
            inc = inc/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findSquareRoot(10, 3));
        System.out.println(findSquareRoot(50, 3));
    }
}
