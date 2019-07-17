package day01.itcast.ioc;

public class UserService {

    // 1. 定义dao类型属性
    private UserDao dao;
    // 2. 生成set方法
    public void setDao(UserDao dao) {
        this.dao = dao;
    }
    public void add() {
        System.out.println("Service add.....");
        // 在service里面需要得到dao的对象，才能引入其中的方法
        dao.add();
        // 之前是这样得到对象
//        UserDao dao = new UserDao();
    }


}
