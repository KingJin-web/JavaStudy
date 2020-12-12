package singer;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ssQueryPages.s")
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
        String page_nums = req.getParameter("page_nums");
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String address = req.getParameter("address");

        int iPage = page == null ? 1 : Integer.parseInt(page);
        int pageNums = page_nums == null ? 1 : Integer.parseInt(page_nums);

        List<SqSinger> list = singerDao.selectPage(iPage,pageNums,name,address,category);

        Gson gson = new Gson();
        String a = gson.toJson(list);
        resp.getWriter().append(a);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
