package HashTable;

import IO.FileOperation;
import Map.Map;

import java.util.ArrayList;

public class Main {

    private static double testHashMap(HashTable<String, Integer> map, String filename) {

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

        String file = "D:\\Projects\\mooc\\data_struc\\src\\HashTable\\Jane Eyre - Charlotte Bronte.txt";

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile(file, words1);

        //
        HashTable<String, Integer> map = new HashTable<String, Integer>();
        double time =  testHashMap(map, file);
        System.out.println("total time of add to hash map is : " + time);
    }
}
