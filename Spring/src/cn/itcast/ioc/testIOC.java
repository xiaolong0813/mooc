package cn.itcast.ioc;

import cn.itcast.property.Book_SetDI;
import cn.itcast.property.Person_Pname;
import cn.itcast.property.Person_complex;
import cn.itcast.property.PropertyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.print.Book;

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
//        System.out.println(user1);
//        System.out.println(user2);
//        user.add();

        PropertyBean demo1 = (PropertyBean) context.getBean("demo1");
        demo1.test1();

        Book_SetDI book = (Book_SetDI) context.getBean("book");
        book.demobook();

        UserService service = (UserService) context.getBean("userService");
        service.add();

        Person_Pname person = (Person_Pname) context.getBean("person");
        person.testPerson();

        Person_complex personC = (Person_complex) context.getBean("personComplex");
        personC.test();



    }


}
