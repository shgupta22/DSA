package bits;

public class CommonBitManipulations {

    public static void checkOddEven(int n) {
        if ((n ^ 1) == n + 1) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

    }

    public static int getIthBit(int n, int i) {
        int mask = (1<<i);
        return (n & mask) > 0 ? 1 : 0;
    }

    public static int setIthBit(int n, int i) {
        int mask = (1<<i);
        return n | mask;
    }

    public static int clearIthBit(int n, int i) {
        int mask = ~(1<<i);
        return  n & mask;
    }

    public static void main(String[] args) {
        checkOddEven(11);
        checkOddEven(12);

        //get ith bit
        System.out.println(getIthBit(5, 2));
        System.out.println(getIthBit(15, 4));

        //set ith bit
        System.out.println(setIthBit(5, 1));
        System.out.println(setIthBit(25, 5));


        //clear ith bit
        System.out.println(clearIthBit(5, 2));
        System.out.println(clearIthBit(13, 2));
    }
}
