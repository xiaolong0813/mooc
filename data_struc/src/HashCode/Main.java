package HashCode;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int a = 42;
        // hashcode方法是Object里面的，需要用包装类转换下类型
        System.out.println(((Integer)a).hashCode());

        // hashcode方法返回的只是整形，不一定是正负，因为整型和索引的对应
        // 需要自己定义
        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "helloworld";
        System.out.println(d.hashCode());

        // 如果不覆盖，用Object默认的hashcode，是针对地址转换的整型
        Student stu = new Student(5, 3, "xu", "xiaolong");
        System.out.println(stu.hashCode());

        HashMap<Student, Integer> map = new HashMap();
        map.put(stu, 100);
        System.out.println("score is : " + map.get(new Student(5, 3, "xu", "xiaolong")));



    }
}
