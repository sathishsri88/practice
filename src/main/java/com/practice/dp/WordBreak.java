package com.practice.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int start = 0, end = 0;
        while (end < s.length()) {
            final String substring = s.substring(start, end + 1);
            if (wordDict.contains(substring)) {
                end++;
                start = end;
            } else {
                end++;
            }
        }
        return end - start == 0;
    }

    @Test
    public void testWordBreak() {
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat", "leet", "code",
                "apple", "pen", "aaaa", "aaa");
//        System.out.println(wordBreak("leetcode", wordDict));
//        System.out.println(wordBreak("catsandog", wordDict));
//        System.out.println(wordBreak("applepenapple", wordDict));
        System.out.println(wordBreak("aaaaaaa", wordDict));
    }
}
