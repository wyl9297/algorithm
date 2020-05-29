import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLongestString {

    public static int lengthOfLongestSubstring1(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        int[] index = new int[128];
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int length = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                length = Math.max(length, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int i = lengthOfLongestSubstring3("abcdecfghika1234567890p");
        System.out.println(i);
    }
}