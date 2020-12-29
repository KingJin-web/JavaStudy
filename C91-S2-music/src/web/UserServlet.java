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
import java.sql.SQLException;

@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    private final UserBiz biz = new UserBiz();

    /**
     * 注册账号
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SqMember sqMember = new SqMember();
        sqMember.setName(req.getParameter("name"));
        sqMember.setPwd(req.getParameter("pwd"));
        sqMember.setEmail(req.getParameter("email"));
        String vcode1 = req.getParameter("vcode1");
        String vcode2 = String.valueOf(req.getSession().getAttribute("vcode2"));

        if (vcode1.equals(vcode2)) {
            try {
                biz.InsertUser(sqMember);
                write(resp, "注册成功 !");
            } catch (BizException e) {
                e.printStackTrace();
                write(resp, e.getMessage());
            }
        } else {
            write(resp, "验证码输入错误，请重新输入 !");
        }


    }

    public void setVcode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        int vcode = (int) ((Math.random() * 9 + 1) * 100000);//生成验证码

        System.out.println(vcode);
        HttpSession session = req.getSession();
        session.setAttribute("vcode2", vcode);
        try {
            biz.SendMail(email, name, vcode);
            write(resp, "发送成功");
        } catch (BizException e) {
            e.printStackTrace();
            write(resp, e.getMessage());
        }
        System.out.println(vcode + email);
    }

    /**
     * 登录
     *
     * @param req
     * @param resp
     * @throws IOException
     */
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

    /**
     * 查询用户信息
     *
     * @param req
     * @param resp
     * @throws IOException
     */
    public void queryUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = String.valueOf(req.getSession().getAttribute("name"));
        //如果session 为空 转为string 则是“null” 字符串 而不是 null
        System.out.println(name);
        if (name == "null" ||  name.equals("null")) {
            write(resp, "请先登录 !");
            return;
        }
        write(resp, biz.queryByName(name));
    }

    public void changeUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqMember sqMember = new SqMember();
        String id = req.getParameter("id");

        sqMember.setId(Integer.valueOf(id));
        sqMember.setNickname(req.getParameter("nickname"));
        sqMember.setPhone(req.getParameter("phone"));
        sqMember.setEmail(req.getParameter("email"));
        sqMember.setQq(req.getParameter("qq"));

        try {
            biz.change(sqMember);
            write(resp, "修改成功");
        } catch (BizException e) {
            e.printStackTrace();
            write(resp, e.getMessage());
        }
    }
}
