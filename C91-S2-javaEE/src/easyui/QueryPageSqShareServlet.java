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

@WebServlet("/QueryPageSqShare.s")
public class QueryPageSqShareServlet extends HttpServlet {
    private SqShareDao shareDao = new SqShareDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> data = new HashMap<>();
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        String page = req.getParameter("page");
        String page_nums = req.getParameter("rows");
        int iPage = page == null ? 1 : Integer.parseInt(page);
        int pageNums = page_nums == null ? 10 : Integer.parseInt(page_nums);
        List<SqShare> rows = shareDao.selectPage(iPage, pageNums);

        int total = shareDao.selectCount();
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
