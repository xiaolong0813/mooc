package day03.transaction;

import day03.c3p0.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testOrder {
    @Test
    public void testService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6_tx.xml");
        OrderService service = (OrderService) context.getBean("orderService");
        service.accountMoney();
    }
}
