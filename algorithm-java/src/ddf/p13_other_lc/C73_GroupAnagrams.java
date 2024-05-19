package ddf.p13_other_lc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams">leetcode 49.字母异位词分组</a>
 * leetcode 热题100
 */
public class C73_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            putInMap(map, new String(cs), str);
        }

        return new ArrayList<>(map.values());
    }

    public void putInMap(Map<String, List<String>> map, String key, String value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(value);
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                while (count[i]-- > 0) {
                    sb.append((char) (i + 'a'));
                }
            }
            putInMap(map, sb.toString(), str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        C73_GroupAnagrams c = new C73_GroupAnagrams();
        System.out.println(
                Arrays.toString(c.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toArray()));

        System.out.println(
                Arrays.toString(c.groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toArray()));
    }

}
