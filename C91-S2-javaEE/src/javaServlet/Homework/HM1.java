package javaServlet.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Homework.s")
public class HM1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        String x = req.getParameter("x");
        String z = req.getParameter("z");
        String y = req.getParameter("y");
        try {
            double a = Double.parseDouble(x), b = Double.parseDouble(y);
            double c = 0;
            switch (z) {
                case "+":
                    c = a + b;
                    break;
                case "-":
                    c = a - b;
                    break;
                case "*":
                    c = a * b;
                    break;
                case "/":
                    c = a / b;
                    break;
            }

            out.print("<h2>" + x + z + y + " = " + c + " </h2>");
        }catch(NumberFormatException e){
            e.printStackTrace();
            out.print("数字输入错误 !");
        }catch(Exception e){
            e.printStackTrace();
            out.print(e.getMessage());
        }
    }
}
