package servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.util.Map;
import java.util.Set;

public class testService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = getServletConfig().getServletContext();

        Map<Integer, String> map = (Map<Integer, String>) context.getAttribute("pdf");

        Set<Integer> keySet = map.keySet();

        for (int key : keySet) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
