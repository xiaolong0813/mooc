package String;

import java.lang.reflect.Field;
import java.util.*;

// String,StringBuffer, StringBuilder的区别
public class StringBufferBuilder {

    public static void testStr() throws Exception {
        String newS1 = new String("hello");
        String newS2 = new String("hello");

        String ss1 = "hello";
        String ss2 = "hello";

        System.out.println("ss1 == ss2 is " + (ss1 == ss2));  // true
        System.out.println("ss1 == newS1 is " + (ss1 == newS1));  // false
        System.out.println("newS1 == newS2 is " + (newS1 == newS2)); // false

        // equals 是用方法String.equals实现比较其value
        System.out.println("ss1 equals newS1 is " + ss1.equals(newS1)); // true
        System.out.println("newS1 equals newS2 is " + newS1.equals(newS2));  // true

        // 利用反射强行修改字符串常量池中的对象值，即String对象hello
        // 获取String类中的value字段.Field类用来反射出类，接口或实例
        // String内部是char[] value和int hash组成，下面用反射改变内部value值
        Field valueFieldOfString = String.class.getDeclaredField("value");

        // 改变value属性的访问权限
        valueFieldOfString.setAccessible(true);
        // 获取ss1对象上的value属性值
        char[] valueSS1 = (char[]) valueFieldOfString.get(ss1);
        // 把value引用的数组的第5个字符改为e
        valueSS1[4] = 'e';

        System.out.println(ss1);   // helle
        System.out.println(newS1); // helle
    }

    public static void testStringBuffer() {
        StringBuffer sbf = new StringBuffer();

        StringBuilder sb = new StringBuilder();

        System.out.println();


    }


    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.add(4);
        list.add(5);
        System.out.println(list);

        TreeSet set = new TreeSet();
        set.add(5);

        Vector vector = new Vector();

        TreeMap map = new TreeMap();

        HashMap map1 = new HashMap();

        Hashtable hashtable = new Hashtable();


//        testStr();
    }
}
