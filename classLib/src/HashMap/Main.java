package HashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void testMap() {
        HashMap map = new HashMap();
        Map safeMap = Collections.synchronizedMap(map);
        safeMap.put("aa", 1);
        safeMap.put("bb", 2);

        Hashtable table = new Hashtable();

        ConcurrentHashMap chashMap = new ConcurrentHashMap();

        System.out.println(safeMap.get("bb"));

        CountDownLatch count = new CountDownLatch(5);

        StringBuffer sbf = new StringBuffer();
        StringBuilder sb = new StringBuilder();


    }


    public static void main(String[] args) {
        Main.testMap();
    }
}
