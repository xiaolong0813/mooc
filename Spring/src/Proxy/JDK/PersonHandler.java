package Proxy.JDK;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 实现InvocationHandle接口生成动态代理类
public class PersonHandler<T> implements InvocationHandler {

    private T target;

    public PersonHandler(T target) {
        this.target = target;
    }
    // 生成targe的代理实例。把target的方法调用赋予handler(this)
    public T createProxyInstance() {
        T proxy = (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        return proxy;
    }
    // 利用代理实例实现所代理的类的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--动态代理前置--");
        method.invoke(target, args);
        System.out.println("--动态代理后置--");

        return null;
    }

}
