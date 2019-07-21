package day03.c3p0;

import day03.jdbcTemplate.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testService {

    @Test
    public void testService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5_c3p0.xml");
        UserService service = (UserService) context.getBean("userService");
        service.add();

    }
}
