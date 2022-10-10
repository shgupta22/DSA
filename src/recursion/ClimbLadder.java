package recursion;

public class ClimbLadder {

    public static int climbLadder(int N) {
        if (N == 0) return 1;
        if (N < 0) return 0;

        return climbLadder(N-1) + climbLadder(N-2) + climbLadder(N-3);
    }

    public static void main(String[] args) {
        System.out.println(climbLadder(5));
        System.out.println(climbLadder(4));
    }
}
