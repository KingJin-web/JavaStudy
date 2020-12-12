package singer;

import easyui.SqShare;
import easyui.SqSong;
import util.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateSqShare")
public class CreateSqShareServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        SqShare ss = new SqShare();
        ss.setName(req.getParameter("name"));
        ss.setSingers(req.getParameter("singers"));
        ss.setType(req.getParameter("type"));


        CreateSqShareServlet cs = new CreateSqShareServlet();
        cs.create(ss);
        resp.getWriter().append("保存成功");
    }
    public void create(SqShare ss) {
        DBHelper db = new DBHelper();
        String sql = "insert into sq_share (name, singers, type) values( ?,?,?) ";
        db.update(sql, ss.getName(), ss.getSingers()
                , ss.getType());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
