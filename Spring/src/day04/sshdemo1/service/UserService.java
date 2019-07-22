package day04.sshdemo1.service;

import day04.sshdemo1.dao.UserDao;
import day04.sshdemo1.dao.UserDaoImpl;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserService {
    // 注入dao对象
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public void add() {
        System.out.println("service.....");
        dao.add();
    }

    public void find() {
        System.out.println("service....");
        dao.find();
    }
}
