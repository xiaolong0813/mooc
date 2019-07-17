package day02.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// 用注解的方法管理bean。其实也是创建对象
@Component(value = "user")  // 等于 <bean id="user" class="..“/>
@Scope(value = "prototype")
public class User {

    public void add() {
        System.out.println("add..........");
    }
}
