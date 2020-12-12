package javaServlet.Homework;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getXian")
public class HM2_getXian extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        int pIndex = Integer.parseInt(req.getParameter("sheng"));
        int cIndex = Integer.parseInt(req.getParameter("shi"));
        if (cIndex <0){
            cIndex = 0;
        }
        String xian[] = AreaConstants.COUNTYS[pIndex][cIndex];
        Gson gson = new Gson();
        String jsonShi = gson.toJson(xian);
        System.out.println(jsonShi);
        resp.getWriter().append(jsonShi);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
