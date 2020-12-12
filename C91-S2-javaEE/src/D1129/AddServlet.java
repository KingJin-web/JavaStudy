package D1129;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add.do")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String oper = req.getParameter("oper");
        double n1 = num1 == null ? 0 : Double.parseDouble(num1);
        double n2 = num2 == null ? 0 : Double.parseDouble(num2);
        double add = 0;
        if (oper == null||oper.equals("")){
            resp.getWriter().append("真是个小天才");
        }else {
            switch (oper) {
                case "+":
                    add = n1 + n2;
                    break;
                case "-":
                    add = n1 - n2;
                    break;
                case "*":
                    add = n1 * n2;
                    break;
                case "/":
                    add = n1 / n2;
                    break;
                case "%":
                    add = n1 % n2;
                    break;
                default:
                    resp.getWriter().append("真是个小天才");
            }
        }


        resp.getWriter().append(String.valueOf(add));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
