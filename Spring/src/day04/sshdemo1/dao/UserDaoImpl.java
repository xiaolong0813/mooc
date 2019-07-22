package day04.sshdemo1.dao;

import day04.sshdemo1.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    // 得到hibernateTemplate的对象
    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
    @Override
    public void add() {
        // hibernateTemplate对hibernate进行了封装.传入sessionFactory
        // 现在这一过程要在配置文件中实现
//        HibernateTemplate template = new HibernateTemplate(SessionFactory);
//        template.update();

        User user = new User();
        user.setUsername("路飞");
        user.setAddress("日本");
        // 调用save方法实现添加
        template.save(user);
    }

    @Override
    public void find() {
        // get 方法。根据id查询
        User user = template.get(User.class, 2);
        System.out.println(user);
        // find 方法
//        1. find方法查询表里面所有记录。hql语句，查找对应类名的表数据，没有条件可以省略
        List<User> list = (List<User>) template.find("from User");
        for (User user1 : list) {
            System.out.println(user1);
        }
//        2. find方法根据条件查询
        List<User> list1 = (List<User>) template.find("from User where username=?", "山治");
        for (User user1 : list1) {
            System.out.println(user1);
        }

//        注意，用find方法做不到分页查询.需要用findByCriteria
//        template.findByCriteria()
    }
}
