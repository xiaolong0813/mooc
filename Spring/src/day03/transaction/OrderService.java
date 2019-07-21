package day03.transaction;

public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    public void accountMoney() {
        System.out.println("service调用dao实现转账");
        // 小王少钱
        orderDao.lessMoney();
        // 如果这里出现了异常，下面的无法执行，则上面的钱就消失了
        int i = 10 / 0;
        // 小马多钱
        orderDao.moreMoney();
    }

}
