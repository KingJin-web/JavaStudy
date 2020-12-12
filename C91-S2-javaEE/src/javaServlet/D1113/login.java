package javaServlet.D1113;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login.s")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        String rvcode = req.getParameter("vcode");
        String svcode = (String) req.getSession().getAttribute("vcode");
        //获取验证码时间
        long oldTime = (long) req.getSession().getAttribute("oldTime");
        System.out.println("oldTime"+oldTime);
        //输入验证码的时间
        String nowTime = req.getParameter("nowTime");
        System.out.println("nowTime"+nowTime);
        if(Long.parseLong(nowTime) - oldTime > 1000*60 ){
            System.out.println("验证码以失效");
            resp.getWriter().append("-2");
            return;
        }
        if (rvcode.equalsIgnoreCase(svcode) == false) {
            resp.getWriter().append("-1");
            return;
        }
        if ("cxk".equals(account) && "123".equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("loginedAccount", account);
            Cookie cookie = new Cookie("loginedAccount", account);
            cookie.setMaxAge(60 * 60 * 24 * 7);
            resp.addCookie(cookie);
            resp.getWriter().append("1");
        } else {
            resp.getWriter().append("2");
        }

        System.out.println(svcode + rvcode);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
