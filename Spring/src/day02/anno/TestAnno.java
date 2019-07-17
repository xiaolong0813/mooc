package day02.anno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {

    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("day02/anno/bean2.xml");
        User user = (User) context.getBean("user");
//        user.add();

        UserService service = (UserService) context.getBean("userService");
        service.add();

    }
}
