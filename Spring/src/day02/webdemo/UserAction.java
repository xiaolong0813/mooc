package day02.webdemo;


import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserAction extends ActionSupport {
    @Override
    public String execute() throws Exception{
        System.out.println("action....");
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        UserService service = (UserService) context.getBean("userService");
        service.service();

        return NONE;
    }
}
