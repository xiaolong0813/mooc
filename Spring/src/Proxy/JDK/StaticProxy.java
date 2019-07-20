package Proxy.JDK;

import Proxy.IPerson;

// 静态代理，扩展实现IPerson接口的实现功能。将需要代理的对象(person)传进来。
// 就可以在不修改对象方法的情况下实现了对say的扩展。但缺陷是接口和代理类是一对一
// 有多少个接口需要代理，就要多少个代理类
public class StaticProxy implements IPerson {

    private IPerson person;

    public void setPerson(IPerson person) {
        this.person = person;
    }
    @Override
    public void say() {
        if (person != null) {
            System.out.println("--静态代理前置--");
            person.say();
            System.out.println("--静态代理后置--");
        }

    }


}
