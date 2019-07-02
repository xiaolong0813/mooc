package IO;// 用来读取文本内容，来进行set测试

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {
// 读取文件名为filename中的内容，并将其包含的词语读入words,如果成功，返回true，失败返回false
//    注意这里readFile是静态方法
//    java中的变量有静态变量和实例变量，实例变量要类实例化后才真正存在，通过对象.变量名访问，静态变量不需要实例化就存在，可以通过类名.变量名访问。
//    静态方法可以有自己的自己的局部变量，只能访问静态变量和静态方法，实例方法则没有这种限制。因为静态成员在对象创建前已经写入内存，而非静态还不存在，
//    所以不能调用.想要静态方法调用非静态成员，就需要把非静态成员写入内存，也就是创建对象。然后调用这个对象就可以了,main函数就可以这样


    public static boolean readFile(String filename, ArrayList<String> words) {
        if (filename == null || words == null) {
            System.out.println("filename is null or words is null");
            return false;
        }

        // 文件读取
//            基于正则表达式的文本扫描器~~可以从文件，输入流，字符串中解析出基本类型和字符串类型的值。
//            Scanner类提供了多个构造器，不同的构造器可以接受文件，输入流，字符串作为数据源，
//            用于从文件，输入流字符串中解析数据
        Scanner scanner;

        try {
            File file = new File(filename);
            if (file.isFile() && file.exists()) {
                // 打开文件流
                FileInputStream fis = new FileInputStream(file);
//                    BufferedInputStream是字节缓冲流，使用BufferedInputStream读资源比FileInputStream读取资源的效率高
//                    BufferedInputStream是套在某个其他的InputStream外，起着缓存的功能，用来改善里面那个InputStream的性能
//                    （如果可能的话），它自己不能脱离里面那个单独存在
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                // 设置Locale，使用英语
                scanner.useLocale(Locale.ENGLISH);
            } else
                return false;
        } catch (IOException e) {
            System.out.println("cannot open " + filename);
            return false;
        }

        // 简单分词
        // 这里分词相对简陋，没考虑很多文本处理的特殊问题，只做demo展示用
        // 一行行的读取
        while (scanner.hasNextLine()) {

            // next方法找到下一个满足delimiter pattern的分量，\A是从字符串开头进行匹配
//            String contents = scanner.useDelimiter("\\A").next();

            // 上面把while改为if，将所有字节一起读入内存，这里是一行行读入
            String contents = scanner.nextLine().trim();

//            System.out.println("************** line *************: " + contents);

            // 从第一个字母字符开始，找到都是字母的，就将其作为单词，直到下一个非字母位置，依次循环
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;

            }
            return true;
        }

    // 寻找字符串s中，从start位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                return i;
        }
        return s.length();
    }

}
