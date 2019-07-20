package day03.jdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class jdbcDemo1 {

    // 1. 添加操作
    @Test
    public void add() {
        // 1）设置数据库信息
        DriverManagerDataSource source = new DriverManagerDataSource();
        // 调用source中的方法设置信息：数据库驱动名 和 数据库地址(本地创建的),用户名,密码
        // 导入mysql-connector-java驱动包后，右键save as lib，然后就可以调用到下面的类名了
        source.setDriverClassName("com.mysql.jdbc.Driver");
        // 新建数据库database为spring。后面不加对于新版本会有编码问题
        source.setUrl("jdbc:mysql:///spring?useUnicode=true&characterEncoding=utf8");
        source.setUsername("root");
        source.setPassword("xuxiao@2198360");

        // 2）创建jdbcTemplate对象，设置数据源。
        JdbcTemplate template = new JdbcTemplate(source);
        // 3) 调用jdbcTemplate对象里面的方法实现操作。提前创建了表user
        String sql = "insert into user values(?,?)";
        // 用的是两参数的update方法。返回的是影响的行数。
        int rows = template.update(sql, "xxl", "250");
        System.out.println(rows);
    }

    // 修改操作
    @Test
    public void update() {
        // 1）设置数据库信息
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql:///spring?useUnicode=true&characterEncoding=utf8");
        source.setUsername("root");
        source.setPassword("xuxiao@2198360");

        JdbcTemplate template = new JdbcTemplate(source);
        String sql = "update user set password=? where username=?";
        int rows = template.update(sql, "266", "xxl");
        System.out.println(rows);
    }

    // 删除操作
    @Test
    public void delete() {
        // 1）设置数据库信息
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql:///spring?useUnicode=true&characterEncoding=utf8");
        source.setUsername("root");
        source.setPassword("xuxiao@2198360");

        JdbcTemplate template = new JdbcTemplate(source);
        String sql = "delete from user where username=?";
        int rows = template.update(sql, "xxl");
        System.out.println(rows);
    }

    // 查询操作
    @Test
    public void find() {
        // 1）设置数据库信息
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql:///spring?useUnicode=true&characterEncoding=utf8");
        source.setUsername("root");
        source.setPassword("xuxiao@2198360");

        JdbcTemplate template = new JdbcTemplate(source);
        // 1) 查询有多少记录
        String sql = "select count(*) from user ";
        // 查询返回某一个值
        int count = template.queryForObject(sql, Integer.class);
        System.out.println(count);

    }



}
