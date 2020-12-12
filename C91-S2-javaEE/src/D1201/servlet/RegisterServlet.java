package D1201.servlet;

import D1201.bean.User;
import D1201.biz.BizException;
import D1201.biz.UserBiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register.s")
public class RegisterServlet extends HttpServlet {
    private final UserBiz userBiz = new UserBiz();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setHeader("content-type", "text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setPhone(req.getParameter("phone"));
        user.setEmail(req.getParameter("email"));
        user.setPwd(req.getParameter("pwd"));
        user.setHead(req.getParameter("head"));

        try {
            userBiz.register(user);
            resp.getWriter().append("注册成功!");
        } catch (BizException e) {
            resp.getWriter().append("注册失败!\n").append(e.getMessage());
        }

    }
}
