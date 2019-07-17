package day01.itcast.property;

import java.util.List;
import java.util.Map;
import java.util.Properties;

// 注入包含复杂类型的类的实例
public class Person_complex {

    private String name;

    public Person_complex() {
    }

    public void setName(String name) {
        this.name = name;
    }

    private String[] arr;
    private List<String> list;
    private Map<String, String> map;
    private Properties properties;
    // 也需要set方法注入，先定义好set方法
    public void setArr(String[] arr) {
        this.arr = arr;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    // 用于测试输出
    public void test() {
        System.out.println("arrs " + arr);
        System.out.println("list " + list);
        System.out.println("map " + map);
        System.out.println("properties " + properties);

    }
}
