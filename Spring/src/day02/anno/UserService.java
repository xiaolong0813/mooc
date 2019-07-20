package day02.anno;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService {

    // 得到dao对象（用注解）
//    1. service里面先创建dao类型属性。注意使用注解不需要手动添加set方法
//    而是在dao属性上面添加注解完成对象注入。
//    1)Autowired为自动装配
//    @Autowired
//    private UserDao userDao;

//    2)用Resource注入。name是要注入对象注解中的value值
    @Resource(name = "userDao")
    private UserDao userDao;

    public void add() {
        System.out.println("service.....");
        // 注入对象就可以调用方法了
        userDao.add();
    }
}
