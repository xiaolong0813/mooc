package cn.itcast.ioc;

import cn.itcast.bean.Bean2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testIOC {

    // 单元测试代码，注意这里引入了junit。可以直接执行
    @Test
    public void testUser() {
        // 1. 加载spring配置文件，根据文件创建对象。
        // spirng里面封装了类.用下面方法加载创建的xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        // 2. 得到配置创建的对象。用里面的方法getBean和定义的id得到一个对象。注意用(User) 转换一下
        User user1 = (User) context.getBean("user");
        User user2 = (User) context.getBean("user");
        // 以下输出地址相同。单例对象
        System.out.println(user1);
        System.out.println(user2);
//        user.add();

//        Bean2 bean2 = (Bean2) context.getBean("bean2");
//        bean2.add();
    }


}
