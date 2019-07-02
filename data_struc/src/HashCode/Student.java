package HashCode;

public class Student {
    int grade;
    int cls;
    String firstName;
    String lastName;

    Student(int grade, int cls, String firstName, String lastName) {
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }


//     // 自定义hash数值
//    @Override
//    public int hashCode() {
//        // 可以随意定义B
//        int B = 31;
//        int hash = 0;
//        // 不一定是数学计算结果，整型溢出后，会调整为其他的整型，比如负值
//        // 针对溢出不用做处理
//        hash = hash * B + grade;
//        hash = hash * B + cls;
//        hash = hash * B + firstName.toLowerCase().hashCode();
//        hash = hash * B + lastName.toLowerCase().hashCode();
//
//        return hash;
//    }

//    // 这里是IntelliJ 直接右键Generate,然后选择equals和hashcode实现的
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return grade == student.grade &&
//                cls == student.cls &&
//                firstName.equals(student.firstName) &&
//                lastName.equals(student.lastName);
//    }
}
