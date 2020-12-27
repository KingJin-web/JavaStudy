package web;

import bean.SqMember;
import biz.UserBiz;
import common.biz.BizException;
import common.util.Utils;
import common.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    private final UserBiz biz = new UserBiz();

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SqMember sqMember = new SqMember();
        sqMember.setName(req.getParameter("name"));
        sqMember.setPwd(req.getParameter("pwd"));
        sqMember.setEmail(req.getParameter("email"));

        try {
            biz.InsertUser(sqMember);
        } catch (BizException e) {
            write(resp, e.getMessage());
        }
        write(resp, "注册成功");
    }

    public void userLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqMember sqMember = new SqMember();
        sqMember.setName(req.getParameter("name"));
        sqMember.setPwd(req.getParameter("pwd"));
        HttpSession session = req.getSession();
        try {
            biz.loginBiz(sqMember);
            write(resp, "登录成功");
            session.setAttribute("name", sqMember.getName());
        } catch (BizException e) {
            write(resp, e.getMessage());
        }

    }

    public void queryUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = String.valueOf(req.getSession().getAttribute("name"));

        try {
            Utils.checkNull(name, "未知错误");

            write(resp, biz.queryByName(name));
        } catch (BizException e) {
            write(resp, e.getMessage());
        }

    }
}
