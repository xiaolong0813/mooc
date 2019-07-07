package Sort;

// 因为要排序，要有可比性，所以需要继承Comparable
public class Student implements Comparable<Student> {

    public String name;
    public int score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    // 自定义对比方法
    // 对比得分，如果得分一样，就对比名字
    @Override
    public int compareTo(Student student) {
        if (this.score == student.score)
            return this.name.compareTo(student.name);
        return this.score - student.score;
    }

    // 自定义打印输出方法
    @Override
    public String toString() {
        return "Student: " + this.name + " " + this.score;
    }
}
