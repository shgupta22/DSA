package recursion;

public class GenerateBrackets {

    public static void generateBrackets(int n) {
        generate(n, 0, 0, 0, "");
    }

    public static void generate(int n, int open, int close, int i, String output) {
        if (i == 2*n) {
            System.out.println(output);
            return;
        }
        if (open < n) {
            generate(n, open+1, close, i+1, output+"(");
        }

        if (close < open) {
            generate(n, open, close+1, i+1, output+")");
        }
    }

    public static void main(String[] args) {
        generateBrackets(3);
        generateBrackets(4);
    }
}
