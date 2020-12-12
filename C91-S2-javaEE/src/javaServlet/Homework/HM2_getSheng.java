package javaServlet.Homework;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/getSheng")
public class
HM2_getSheng extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");
        String[] pros = AreaConstants.PROVINCES;

        Gson gson = new Gson();
        String jsonSeng = gson.toJson(pros);
        System.out.println(jsonSeng); //输出["a","b","c"]
        resp.getWriter().append(jsonSeng);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

