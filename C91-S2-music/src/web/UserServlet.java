package web;

import bean.SqMember;
import biz.UserBiz;
import common.web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    private final UserBiz biz = new UserBiz();

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SqMember sqMember = new SqMember();
        sqMember.setName(req.getParameter("name"));
        sqMember.setPwd(req.getParameter("pwd"));
        sqMember.setEmail(req.getParameter("email"));

        biz.InsertUser(sqMember);
        write(resp, "注册成功");
    }

}
