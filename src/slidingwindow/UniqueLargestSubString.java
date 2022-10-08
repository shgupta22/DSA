package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class UniqueLargestSubString {

    public static String uniqueSubString(String s) {
        int i=0;
        int j =0;
        int windowLen = 0;
        int maxWindow = 0;
        int startWindow = -1;

        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {

            char c = s.charAt(j);

            //if c is in Map & its idx >= start of the current window
            if (map.containsKey(c) && map.get(c) >= i) {
                i = map.get(c) + 1;
                windowLen = j -i;
            }

            //update the map
            map.put(c, j);
            windowLen++;
            j++;

            if (windowLen > maxWindow) {
                maxWindow = windowLen;
                startWindow = i;
            }
        }
        return s.substring(startWindow, startWindow + maxWindow);
    }

    public static void main(String[] args) {
        System.out.println(uniqueSubString("abcabeb"));
    }
}
