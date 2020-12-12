package javaServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello.s")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello World get</h1>" + "<h2>你好</h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello World post</h1>" + "<h2>你好</h2>");
    }

    public HelloServlet() {
        super();
    }

    /**
     * 执行N次 访问N次执行N次
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===service : ===");
        super.service(req, resp);
    }

    /**
     * 服务器正常停止执行
     */
    @Override
    public void destroy() {
        System.out.println("===destroy : 停止===");
        super.destroy();
    }

    /**
     * 执行一次
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("===init : 初始===");
        super.init();
    }


}
