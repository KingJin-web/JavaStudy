package easyui;

import com.google.gson.Gson;
import javaServlet.HelloServlet;
import singer.SqSingerBiz;
import singer.SqSingerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteSinger")
public class DeleteSingerServlet extends HelloServlet {
    private final SqSingerBiz singerBiz = new SqSingerBiz();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        String id = req.getParameter("id");


        singerBiz.delete(id);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
