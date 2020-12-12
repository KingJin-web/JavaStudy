package javaServlet.cross_domain;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/crossdomain2")
public class Servlet2 extends HttpServlet{
    /**
     * 解决方式1：响应头添加Header允许访问
     * 跨域资源共享（CORS）Cross-Origin Resource Sharing
     * 这个跨域访问的解决方案的安全基础是基于"JavaScript无法控制该HTTP头"
     * 它需要通过目标域返回的HTTP头来授权是否允许跨域访问。
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Method","POST,GET");//允许访问的方式
        String callback = req.getParameter("callback");
        if (callback == null||callback.equals(null)){
            callback = "测试";
        }
        resp.getWriter().append(callback + "Hello world");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }



}
