package day03.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 需要得到jdbcTemplate对象，在配置中注入,设置set方法
    private JdbcTemplate jdbcTemplate;

    // 实现添加数据的操作
    public void add() {
        // 配置文件以及链接了数据库
        String sql = "insert into user values(?,?)";
        jdbcTemplate.update(sql, "路飞","12345");

    }


}
