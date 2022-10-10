package recursion;

import java.util.ArrayList;
import java.util.List;

public class FindSubSets {

    static List<String> result = new ArrayList<>();

    public static void subSequence(String str) {
        findSubSequence(str, "");
    }

    public static void findSubSequence(String str, String ans) {
        if (str.isEmpty()) {
            result.add(ans);
            return;
        }

        findSubSequence(str.substring(1), ans + str.charAt(0));
        findSubSequence(str.substring(1), ans );
    }

    public static void main(String[] args) {
        subSequence("abc");
        System.out.println(result);
        result = new ArrayList<>();
        subSequence("abcd");
        System.out.println(result);
    }
}
