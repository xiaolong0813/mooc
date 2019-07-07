//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//案例:
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
//注意事项：您可以假定该字符串只包含小写字母


public class Q387_hash {

    // 建立对应26个字母的数组，遍历字符串，保存每个对应位置出现的次数，
    // 再重新遍历字符串，找到第一个为一的位置
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i =0; i < s.length(); i ++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i =0; i < s.length(); i ++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Q387_hash q = new Q387_hash();
        System.out.println(q.firstUniqChar("loveleetcode"));
    }
}


