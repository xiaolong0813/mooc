package day01.bean;

public class Bean3_InstanceFactory {

    // 普通方法，不用静态，返回bean3对象
    public Bean3 getBean3() {
        return new Bean3();
    }
}
