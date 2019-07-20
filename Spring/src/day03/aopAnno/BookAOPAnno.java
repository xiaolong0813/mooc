package day03.aopAnno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 类上面注解
@Aspect
public class BookAOPAnno {
    // 方法上面使用注解完成增强方法配置
    @Before(value = "execution(* day03.aopAnno.Book.*(..))")
    public void before1() {
        System.out.println("before......");
    }
}
