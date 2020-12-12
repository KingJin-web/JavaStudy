package javaServlet;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dome111", urlPatterns = {"/dome.s", "/do.s"}, initParams = {@WebInitParam(name = "welcome", value = "yc")})
public class Dome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(this.getServletContext());
        System.out.println(req);
        System.out.println(resp);

        String name = req.getParameter("name");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<h2> "+ name + " 你好</h2>");

        String x = req.getParameter("x");
        String y = req.getParameter("y");

        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
        int c = a+b;
        out.print("<h2>" + x + " + " + y + " = " + c + " </h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        String x = req.getParameter("x");
        String y = req.getParameter("y");

        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
        int c = a+b;
        out.print("<h2>" + x + " + " + y + " = " + c + " </h2>");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(servletConfig.getInitParameter("welcome"));
    }
}
