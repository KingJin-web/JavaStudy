package singer;

import easyui.SqSong;
import util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateSqSong")
public class CreateSqSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        SqSong ss = new SqSong();
        ss.setName(req.getParameter("name"));
        ss.setSinger(req.getParameter("singer"));
        ss.setType(req.getParameter("type"));
        ss.setSize(req.getParameter("size"));

        CreateSqSongServlet cs = new CreateSqSongServlet();
        cs.create(ss);
        resp.getWriter().append("保存成功");
    }

    public void create(SqSong ss) {
        DBHelper db = new DBHelper();
        String sql = "insert into sq_song (name, singer, type, size) values( ?,?,?,?) ";
        db.update(sql, ss.getName(), ss.getSinger()
                , ss.getType(), ss.getSize());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
