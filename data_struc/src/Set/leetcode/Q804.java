package Set.leetcode;

import java.util.TreeSet;

public class Q804 {

    private String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..",
            "--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {

        // 相对于自己编写的bst的优势：
        // 1. 底层树结构是红黑树（平衡二叉树）
        // 2. 除了增删查等操作，还添加了很多其他操作。都是和bst具有顺序性相关的
        TreeSet<String> set = new TreeSet<>();

        for (String word: words) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                // 对于a的偏移就是索引号
                sb.append(codes[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }

}
