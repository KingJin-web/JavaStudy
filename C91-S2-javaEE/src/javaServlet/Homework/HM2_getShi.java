package javaServlet.Homework;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getShi")
public class HM2_getShi extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");
        int pIndex = Integer.parseInt(req.getParameter("sheng"));
        String shi[] = AreaConstants.CITYS[pIndex];
        Gson gson = new Gson();
        String jsonShi = gson.toJson(shi);
        System.out.println(jsonShi);
        resp.getWriter().append(jsonShi);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
