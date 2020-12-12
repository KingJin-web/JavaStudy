package singer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateSqSinger")
public class CreateSqSingerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");

        SqSinger ss = new SqSinger();
        ss.setName(req.getParameter("name"));
        ss.setCategory(req.getParameter("category"));
        ss.setBirthday(req.getParameter("birthday"));
        ss.setMembers(req.getParameter("members"));
        SqSingerBiz sqSingerBiz = new SqSingerBiz();
        sqSingerBiz.create(ss);
        resp.getWriter().append("保存成功");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

