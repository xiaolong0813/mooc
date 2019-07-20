package day02.webdemo;

public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void service() {
        userDao.add();
        System.out.println("service.......");
    }


}
