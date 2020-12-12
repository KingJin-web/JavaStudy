package easyui;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/QueryPageSqSong.s")
public class QueryPageSqSongServlet extends HttpServlet {
    private final SqSongDao songDao = new SqSongDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String page = req.getParameter("page");
        String page_nums = req.getParameter("rows");
        int iPage = page == null ? 1 : Integer.parseInt(page);
        int pageNums = page_nums == null ? 10 : Integer.parseInt(page_nums);

        List<SqSong> rows = songDao.selectPage(iPage, pageNums);

        Map<String, Object> data = new HashMap<>();

        int total = songDao.selectCount();
        data.put("rows", rows);
        data.put("total", total);
        Gson gson = new Gson();
        String a = gson.toJson(data);
        resp.getWriter().append(a);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
