package LC_Hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    public static String minWindow(String s, String t) {
        if (s.length() == 0|| t.length() == 0) return "";

        Map<Character, Integer> dictT = new HashMap<>();
        for (char c: t.toCharArray()) {
            int count = dictT.getOrDefault(c, 0);
            dictT.put(c, count+1);
        }

        int required = dictT.size();
        int l = 0; int r = 0;
        int formed = 0;

        Map<Character, Integer> windowCount = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCount.getOrDefault(c, 0);
            windowCount.put(c, count+1);

            if (dictT.containsKey(c) && windowCount.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (l<=r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r-l+1 < ans[0]) {
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCount.put(c, windowCount.get(c)-1);
                if (dictT.containsKey(c) && windowCount.get(c) < dictT.get(c)) {
                    formed--;
                }
                l++;
            }
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); //BANC
    }
}
