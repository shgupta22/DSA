import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, wordDict, new HashMap<>());
    }

    public static boolean dp(String target, List<String> wordDict, Map<String, Boolean> map) {
        if(map.containsKey(target)) return map.get(target);
        if(target.isEmpty()) return true;

        for (String word: wordDict) {
            if (target.indexOf(word) ==0) {
                String sub = target.substring(word.length());
                if (wordBreak(sub, wordDict)){
                    map.put(target, true);
                    return true;
                }
            }
        }
        map.put(target, false);
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
