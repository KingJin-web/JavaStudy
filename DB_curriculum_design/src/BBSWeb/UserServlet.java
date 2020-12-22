package BBSWeb;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BBSBean.UserBean;
import BBSBiz.LoginBiz;
import BBSBiz.RegBiz;
import common.biz.BizException;
import common.web.BaseServlet;

@WebServlet("/Logincheck.s")
public class UserServlet extends BaseServlet {

    /**
     *
     */

    private static final long serialVersionUID = 1L;
    private LoginBiz lb = new LoginBiz();
    private RegBiz rb = new RegBiz();

    public void Logincheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        try {
            UserBean boardLogin = lb.BoardLogin(uname, upass);
            response.getWriter().append("登录成功");
            HttpSession session = request.getSession();
            session.setAttribute("usercount", boardLogin.getId());
        } catch (BizException e) {
            response.getWriter().append("登录失败！！！ 原因:" + e.getMessage());
        }

    }

    public void UserReg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserBean ub = new UserBean();
        String uname = request.getParameter("uname");
        String upass = request.getParameter("upass");
        String head = request.getParameter("head");
        String gender = request.getParameter("gender");
        String repupass = request.getParameter("repupass");
        ub.setUname(uname);
        ub.setUpass(upass);
        ub.setHead(head);
        ub.setGender(Integer.parseInt(gender));
        try {
            rb.create(ub, repupass);
            response.getWriter().append("注册成功");
        } catch (BizException e) {
            response.getWriter().append("注册失败  原因:" + e.getMessage());
        }

    }


}
