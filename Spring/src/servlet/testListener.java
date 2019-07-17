package servlet;

import org.apache.catalina.startup.Tomcat;
import org.jcp.xml.dsig.internal.dom.Utils;
import sun.net.www.http.HttpClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.ConnectionEvent;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

// 这是tomcat内部容器
// servlet容易启动或者终止api应用时，会触发ServletContextEvent事件，该事件由
// servletContextListener处理。
public class testListener implements ServletContextListener {

    // 实现其中的方法一，销毁函数
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("这是最后一次销毁!");
    }
    // 实现其中方法二，初始化函数，有事件发生时触发
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();

        Map<Integer, String> map = new HashMap<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        // mysql setting
        String jdbcUrl = "jdbc:mysql://localhost:3306/autocheck?useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true";
        String username = "siemens";
        String password = "siemens";

        try {
            // 读取数据库数据
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            // 检索语句
            String sql = "use translation;select * from pdf;";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                map.put(resultSet.getInt(1), resultSet.getString(2));
            }
            // 将检索到的值存放到一个属性键值对中
            context.setAttribute("pdf", map);

            System.out.println("------------listener test is beginning!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
