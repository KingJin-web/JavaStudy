package easyui;

import com.google.gson.Gson;
import singer.SqSinger;
import singer.SqSingerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/ssQueryPagesEasyui.s")
public class QueryPageSqSingerServlet extends HttpServlet {
    private final SqSingerDao singerDao = new SqSingerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器接收中文乱码
        req.setCharacterEncoding("utf-8");
        //服务器发送中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        String page = req.getParameter("page");
        String page_nums = req.getParameter("rows");
        int iPage = page == null ? 1 : Integer.parseInt(page);
        int pageNums = page_nums == null ? 10 : Integer.parseInt(page_nums);

        List<SqSinger> rows = singerDao.selectPage(iPage,pageNums);
        List<SqSinger> row = singerDao.selectPage();
        int total = row.size();
        Map<String,Object> data = new HashMap<>();
        data.put("rows",rows);
        data.put("total",total);
        Gson gson = new Gson();
        String a = gson.toJson(data);
        resp.getWriter().append(a);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
