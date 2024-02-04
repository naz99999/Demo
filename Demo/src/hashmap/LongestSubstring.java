package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        int n = s.length();
        int left = 0;
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right=0; right<n; right++) {
            if (!map.containsKey(s.charAt(right)) || map.get(s.charAt(right))<left) {
                map.put(s.charAt(right), right);
                maxCount = Math.max(maxCount, right-left+1);
            } else {
                left = map.get(s.charAt(right))+1;
                map.put(s.charAt(right), right);
            }
        }
        System.out.println(maxCount);
    }
}

