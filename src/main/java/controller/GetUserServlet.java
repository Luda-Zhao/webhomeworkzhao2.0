package controller;

import service.ServiceFactory;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/getuser")
public class GetUserServlet extends HttpServlet {
    // 基于ServiceFactory工厂，获取单例的UserService组件
    private UserService userService = ServiceFactory.getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取指定ID用户的详细信息
        int id = Integer.parseInt(req.getParameter("uid"));
        req.setAttribute("user", userService.getUser(id));
        req.getRequestDispatcher("/WEB-INF/jsp/getuser.jsp")
                .forward(req, resp);

    }
}