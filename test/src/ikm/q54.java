package ikm;

import java.io.File;

public class q54 {

    public static void main (String[] args) {
        File file = new File("ikm/test.txt");
        File backup = new File("test.txt.bak");
        backup.delete();
        file.renameTo(backup); // Location 1
    }
}
