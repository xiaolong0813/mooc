package day02.anno;

import org.springframework.stereotype.Component;

// 注解用于创建对象注入service
@Component(value = "userDao")
public class UserDao {

    public void add() {
        System.out.println("dao......");
    }
}
