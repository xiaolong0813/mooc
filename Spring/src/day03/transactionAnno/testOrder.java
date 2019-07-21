package day03.transactionAnno;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testOrder {

    @BeforeClass
    public static void beforeclass() {
        System.out.println("before class...");
    }

    @AfterClass
    public static void afterclass() {
        System.out.println("after class...");
    }

    @Test
    public void testService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7_txAnno.xml");
        OrderService service = (OrderService) context.getBean("orderService");
        service.accountMoney();
    }
}
