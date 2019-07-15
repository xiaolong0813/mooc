package IOC;

public class IOC {

    public static void testIOC() throws Exception {

        String className = "IOC.Student";
        Class clazz = Class.forName(className);
        Student stu = (Student) clazz.newInstance();
        stu.setName("xxl");
        stu.setScore(100);
        System.out.println(stu.getName());
    }

    public static void main(String[] args) throws Exception {
        testIOC();
    }
}
