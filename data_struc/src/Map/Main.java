package Map;

import IO.FileOperation;

import java.util.ArrayList;

public class Main {

    private static double testMap(Map<String, Integer> map, String filename) {

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile(filename, words1);

        System.out.println("Total words: " + words1.size());

        double startTime = System.nanoTime();

        for (String word: words1) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            }
            else
                map.add(word, 1);
        }
        System.out.println("Total different words in Map: " + map.getSize());
        System.out.println("Freq of Jane: " + map.get("jane"));
        System.out.println("Freq of Eyre: " + map.get("eyre"));


        double endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String file = "D:\\Projects\\mooc\\data_struc\\src\\Map\\Jane Eyre - Charlotte Bronte.txt";

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile(file, words1);

        LinkedListMap<String, Integer> map = new LinkedListMap<String, Integer>();
        double time =  testMap(map, file);
        System.out.println("total time of add to linkedlist map is : " + time);

        System.out.println();

        BSTMap<String, Integer> map1 = new BSTMap<String, Integer>();
        double time1 =  testMap(map1, file);
        System.out.println("total time of add to bst map is : " + time1);
    }
}
