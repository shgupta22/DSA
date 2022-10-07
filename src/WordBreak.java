import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {

        return dp(s, wordDict, new HashMap<>());
    }

    public static boolean dp(String s, List<String> wordDict, Map<String, Boolean> map) {
        if(map.containsKey(s)) return map.get(s);
        if(s.isEmpty()) return true;

        for (String word: wordDict) {
            if (s.indexOf(word) ==0) {
                String sub = s.substring(word.length());
                if (wordBreak(sub, wordDict)){
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

}
