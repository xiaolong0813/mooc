//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1:
//输入: ["flower","flow","flight"]
//输出: "fl"
//
//示例 2:
//输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//说明:
//所有输入只包含小写字母 a-z 


import org.omg.CORBA.IRObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q14_String {

    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0)
//            return "";
//        String pre = strs[0];
//        for (int i = 1;i < strs.length; i++) {
//            pre = commonPre(pre, strs[i]);
//            if (pre.length() == 0)
//                break;
//        }
//        return pre;
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }

        int mid = (l + r) / 2;

        String str1 = longestCommonPrefix(strs, l, mid);
        String str2 = longestCommonPrefix(strs, mid + 1, r);

        return commonPre(str1, str2);
    }

    private static String commonPre(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0)
            return "";
//        int len = str1.length() > str2.length() ? str2.length() : str1.length();
        int len = Math.min(str1.length(), str2.length());
//        StringBuilder pre = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i))
                return str1.substring(0, i);
        }

        return str1.substring(0, len);
    }

    public static void main(String[] args) {

//        System.out.println("dogs".indexOf("dx"));

        System.out.println(Q14_String.longestCommonPrefix(new String[]{"dog","doracecar","docar"}));


    }


}
