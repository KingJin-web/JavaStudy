package web;

import bean.DygMsg;
import biz.BizException;
import biz.MsgBiz;
import dao.DygDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addMsg.s")
public class addMsgServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");


        DygMsg msg = new DygMsg();
        msg.setCreateName(req.getParameter("CreateName"));
        msg.setEmail(req.getParameter("Email"));
        msg.setContent(req.getParameter("Content"));

        MsgBiz msgBiz = new MsgBiz();
        try {
            msgBiz.addMsg(msg);
            resp.getWriter().append("留言成功");
        } catch (BizException e) {
            resp.getWriter().append(e.getMessage());

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
