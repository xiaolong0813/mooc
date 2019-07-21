package day03.jdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.List;

public class jdbcDemo1 {
    private String driver = "com.mysql.jdbc.Driver";
    private String mysqlUrl = "jdbc:mysql:///spring?useUnicode=true&characterEncoding=utf8";
    private String mysqlUser = "root";
    private String mysqlPwd = "xuxiao@2198360";

    // c3p0连接池原始写法（不用配置文件）
    public void pool() throws Exception {
        // 配置连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(mysqlUrl);
        dataSource.setUser(mysqlUser);
        dataSource.setPassword(mysqlPwd);
    }

    // 1. 添加操作
    @Test
    public void add() {
        // 1）设置数据库信息
        DriverManagerDataSource source = new DriverManagerDataSource();
        // 调用source中的方法设置信息：数据库驱动名 和 数据库地址(本地创建的),用户名,密码
        // 导入mysql-connector-java驱动包后，右键save as lib，然后就可以调用到下面的类名了
        source.setDriverClassName(driver);
        // 新建数据库database为spring。后面不加对于新版本会有编码问题
        source.setUrl(mysqlUrl);
        source.setUsername(mysqlUser);
        source.setPassword(mysqlPwd);

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
        source.setDriverClassName(driver);
        source.setUrl(mysqlUrl);
        source.setUsername(mysqlUser);
        source.setPassword(mysqlPwd);

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
        source.setDriverClassName(driver);
        source.setUrl(mysqlUrl);
        source.setUsername(mysqlUser);
        source.setPassword(mysqlPwd);

        JdbcTemplate template = new JdbcTemplate(source);
        String sql = "delete from user where username=?";
        int rows = template.update(sql, "xxl");
        System.out.println(rows);
    }

    // 查询操作

//    注意
//    1）在dbutils时，有接口ResultSetHandler，dbutils提供了针对不同结果实现类
//    2）在jdbcTemplate实现查询，有接口RowMapper，针对这个接口没有实现类，得到不同类型数据需要自己进行
//    数据封装
    // 1. jdbcTemplate 实现查询单值
    @Test
    public void find() {
        // 1）设置数据库信息
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driver);
        source.setUrl(mysqlUrl);
        source.setUsername(mysqlUser);
        source.setPassword(mysqlPwd);

        JdbcTemplate template = new JdbcTemplate(source);
        // 查询有多少记录
        String sql = "select count(*) from user ";
        // 查询返回某一个值
        int count = template.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    // 2. jdbcTemplate 实现查询对象
    @Test
    public void findObject() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driver);
        source.setUrl(mysqlUrl);
        source.setUsername(mysqlUser);
        source.setPassword(mysqlPwd);

        JdbcTemplate template = new JdbcTemplate(source);
        // sql语句，根据username进行查询
        String sql = "select * from user where username=?";
        // 调用jdbcTemplate模板中的方法进行查询
        // rowMapper 是返回对象的接口.需要自己写类实现接口
        User user = template.queryForObject(sql, new MyRowMapper(), "lucy");
        System.out.println(user);
    }



    // 3. jdbc查询底层实现代码，实现查询对象，上面的模板只是对下面进行了封装
    @Test
    public void testJDBC() {
        // 加载驱动,预编译对象,结果集
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet set = null;
        try {
            // ckassLoader 加载驱动
            Class.forName(driver);
            // 建立连接
            conn = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPwd);
            // sql 语句
            String sql = "select * from user where username=?";
            // 预编译sql
            psmt = conn.prepareStatement(sql);
            // 设置参数值
            psmt.setString(1, "lucy");
            // 执行sql
            set = psmt.executeQuery();
            // 遍历结果集
            while (set.next()) {
                // 得到返回结果值
                String username = set.getString("username");
                String password = set.getString("password");
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭链接
            try {
                set.close();
                conn.close();
                psmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    4. 查询返回list
    @Test
    public void findList() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(driver);
        source.setUrl(mysqlUrl);
        source.setUsername(mysqlUser);
        source.setPassword(mysqlPwd);

        JdbcTemplate template = new JdbcTemplate(source);
        // 查询表中所有记录
        String sql = "select * from user";
        // 调用jdbcTemplate模板中的方法进行查询
        // rowMapper 是返回对象的接口.需要自己写类实现接口
        List<User> list = template.query(sql, new MyRowMapper());
        System.out.println(list);
    }
}


// RowMapper 接口实现类
class MyRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        // 1. 从结果集把数据得到
        String usrname = resultSet.getString("username");
        String password = resultSet.getString("password");
        // 2. 把得到的数据封装到对象
        User user = new User();
        user.setPassword(password);
        user.setUsername(usrname);
        return user;
    }
}