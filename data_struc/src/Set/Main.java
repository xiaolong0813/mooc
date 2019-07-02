package Set;

import java.util.ArrayList;
import IO.FileOperation;

public class Main {

    private static double testSet(Set<String> set, String filename) {

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile(filename, words1);

        System.out.println("Total words: " + words1.size());

        // 计算bst集合的时间
        double startTime = System.nanoTime();

        for (String word: words1) {
            set.add(word);
        }
        System.out.println("Total different words/BST: " + set.getSize());

        double endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String file = "D:\\Projects\\mooc\\data_struc\\src\\Set\\Jane Eyre - Charlotte Bronte.txt";

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile(file, words1);

        // BST 实现的集合测试
        BSTSet<String> set1 = new BSTSet<String>();
        System.out.println("The time of bstset is : " + testSet(set1, file));

//        // 链表 实现的集合测试
//        LinkedListSet<String> set2 = new LinkedListSet<String>();
//        System.out.println("The time of linkedlistSet is : " + testSet(set2, file));

    }
}
