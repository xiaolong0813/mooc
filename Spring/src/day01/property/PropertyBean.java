package day01.property;

public class PropertyBean {

    private String username;

    // 用有参构造的方式注入属性
    public PropertyBean(String name) {
        this.username = name;
    }

    // 测试，输出属性值
    public void test1() {
        System.out.println("user name of demo1 is " + username);
    }
}
