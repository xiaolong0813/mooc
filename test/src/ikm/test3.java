package ikm;

import com.sun.deploy.net.HttpRequest;

import javax.activation.DataSource;
import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

public class test3 {

//    language = Locale.getDefault().getLanguage();
//
//    language = System.getLanguage();

//    ArrayList<String> peopleNames = new ArrayList();
//    peopleNames.add("John");
//    peopleNames.add("Michelle");
//    peopleNames.add("Michael");
//    peopleNames.add("Susan");
//
//    request.setAttribute("favoriteNames", peopleNames);

//    public class MyJDBCInsertServlet extends HttpServlet {
//        @Resource(name="jdbc/TimetableDBPool")
//        private DataSource dataSource;
//        @Override
//        protected void doGet (HttpServletRequest request, HttpServletResponse
//                response) throws ServletException, IOException {
//            String insertSql= "INSERT INTO purchase_order (id, description)  VALUES(?,?)";
//            try {
//                Connection connection = dataSource.getConnection();
//                PreparedStatement insertStatement =
//                        connection.prepareStatement(insertSql);
//                insertStatement.setInt(1, 12345);
//                insertStatement.setString(2, "QAC Demo");
//                insertStatement.executeInsert(); ….
//                insertStatement.close();
//                connection.close();
//            }
//            catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
