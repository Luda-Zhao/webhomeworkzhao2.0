package controller;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Admin.html")
                .forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("pwd");
        String url;
        if ("2557797320@qq.com".equals(userName) && "123456".equals(password)) {
            User u = new User(2017214328,"王小明");
            req.getSession().setAttribute("user", u);
            text t=new text();
            url = "WEB-INF/jsp/index.jsp";
        } else {
            url = "/Admin.html";
        }
//        resp.sendRedirect(url);
        req.getRequestDispatcher(url).forward(req,resp);
    }
}
