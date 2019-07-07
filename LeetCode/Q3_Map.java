import java.util.*;

public class Q3_Map {

    public int lengthOfLongestSubstring(String s) {

//        这道题主要用到思路是：滑动窗口
//        什么是滑动窗口？
//        其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，
//        当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
//        如何移动？
//        我们只要把队列的左边的元素移出就行了，直到满足题目要求！
//        一直维持这样的队列，找出队列出现最长的长度时候，求出解！
//        时间复杂度：O(n)

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

//    private String longSubstring(String s) {
//        if (s.length() == 1)
//            return
//    }

    public static void main(String[] args) {
//
        Q3_Map q = new Q3_Map();
        System.out.println(q.lengthOfLongestSubstring("pwwkew"));

        Queue sq = new LinkedList();
    }
}
