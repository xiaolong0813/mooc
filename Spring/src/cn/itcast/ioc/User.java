package cn.itcast.ioc;

public class User {

    // 如果什么都不写，默认是无参构造，如果这里写了带参数的
    // 构造函数，就是有参构造
    private String username;

    public User(String username) {
        this.username = username;
    }

    // 但如果包含了下面的无参构造函数，就可以实例化了
    public User() {
    }
    // 属性注入第一种方法，set函数
    public void setUsername(String name) {
        this.username = name;
    }

    public void add() {
        System.out.println("add.....");
    }



    public static void main(String[] args) {
        // 原始方法
//        User user = new User();
//        user.add();
    }
}
