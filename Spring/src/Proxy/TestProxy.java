package Proxy;

import Proxy.JDK.PersonHandler;
import Proxy.JDK.StaticProxy;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestProxy {

    public static void main(String[] args) {
        // 没有代理
        Man man = new Man();
        man.say();
        // 静态代理方式扩展Man的say功能
        StaticProxy proxy1 = new StaticProxy();
        proxy1.setPerson(man);
        proxy1.say();

        // 动态代理方式扩展Man的say功能
        PersonHandler<IPerson> handler = new PersonHandler(man);
        IPerson proxy2 = handler.createProxyInstance();
        proxy2.say();

        // 这是动态生成的class文件，写到文件里
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy",
                Man.class.getInterfaces());
        String path = "Man.class";
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("代理类class文件写入错误");
        }
    }
}
