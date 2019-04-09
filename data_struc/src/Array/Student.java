package Array;
import Array.*;

public class Student {

    private String name;
    private int score;

    public Student(String stuName, int stuScore) {
        name = stuName;
        score = stuScore;
    }



    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) throws IllegalAccessException {
        // 默认参数为10
        Array<Student> stuArr = new Array<Student>();

        stuArr.addLast(new Student("xxl", 100));
        stuArr.addLast(new Student("Bob", 95));
        stuArr.addLast(new Student("Alice", 65));

        System.out.println(stuArr);

    }
}
