package day02.aop;

import org.aspectj.lang.ProceedingJoinPoint;

// 增强Book的AOP类
public class BookAOP {
    // 前置增强。在被增强方法之前执行
    public void before1() {
        System.out.println("前置增强...");
    }

    // 后置增强
    public void after1() {
        System.out.println("后置增强....");
    }
    // 环绕增强。（前后都要执行）
    public void around1(ProceedingJoinPoint point) throws Throwable {
        // 方法之前
        System.out.println("方式之前....");
        // 执行被增强方法
        point.proceed();
        // 方法之后
        System.out.println("方式之后....");

    }
}
