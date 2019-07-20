package day02.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAOP {

    @Test
    public void testAOP() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Book book = (Book) context.getBean("book");

        book.add();
    }
}
