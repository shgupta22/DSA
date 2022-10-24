package recursion;

import java.util.List;
import java.util.Map;

public class MaxLengthConcatenatedString {

    public static int maxLength(List<String> arr) {
        return recursion(arr, "", 0);
    }

    public static int recursion(List<String> arr, String soFarStr, int start) {
        if (start == arr.size()) {
            if (isValid(soFarStr)) {
                return soFarStr.length();
            }
            return 0;
        }

        int s1 = recursion(arr, soFarStr, start+1);
        int s2 = recursion(arr, soFarStr+arr.get(start), start+1);
        return Math.max(s1, s2);
    }

    public static boolean isValid(String str) {
        int[] freq = new int[26];

        for (char c: str.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(List.of("un","iq","ue"))); //4 - "uniq" ("un" + "iq") or - "ique" ("iq" + "ue")
        System.out.println(maxLength(List.of("cha","r","act","ers"))); //6 ("cha" + "ers") or ("act" + "ers")
    }
}
