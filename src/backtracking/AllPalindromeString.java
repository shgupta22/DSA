package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPalindromeString {

    /**
     * Backtrack Recipe:
     * 1) Take Input, Result, TempStorage, StartIndex/StartValue
     * 2) If Start == Input.length // breaking condition
     * 3) Add the Temp to Result
     *
     * 4) Else for each Index from Start to Length of Input, check isPalindrome
     * 5) If True Temp add SubString of Input[start to i+1] and make Recursive Call with Input, Result, Temp, I+1
     * 6) Remove the last added substring from Temp.remove(temp.size()-1)
     */

    public static List<List<String>> palindrome(String s) {
        List<List<String>> result = new ArrayList<>();
        backtack(result, new ArrayList<>(), s, 0);
        return result;
    }

    public static void backtack(List<List<String>> result, List<String> templist, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(templist));
        } else {
            for (int i =start; i < s.length(); i++) {
                if(isPalindrome(s, start,i)) {
                    templist.add(s.substring(start, i+1));
                    backtack(result, templist, s, i+1);
                    templist.remove(templist.size()  -1);
                }
            }
        }
    }

    public static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(palindrome("aab"));
        System.out.println(palindrome("aabaa"));
    }
}
