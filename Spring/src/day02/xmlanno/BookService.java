package day02.xmlanno;

import javax.annotation.Resource;

public class BookService {

    // 在service里面得到bookdao和orderdao的对象
    // 引入两个类的属性.name是配置文件中对应的bean的id
    @Resource(name = "bookDao")
    private BookDao bookDao;
    @Resource(name = "orderDao")
    private OrderDao orderDao;

    public void add() {
        System.out.println("service add......");
        // 调用两个对象中的方法测试
        bookDao.book();
        orderDao.buy();
    }
}
