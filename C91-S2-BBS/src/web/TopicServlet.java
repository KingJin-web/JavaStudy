package web;

import biz.TopicBiz;
import dao.TopicDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


@WebServlet("/topic.s")
public class TopicServlet extends BaseServlet {
    private final TopicDao tDao = new TopicDao();
    private final TopicBiz tBiz = new TopicBiz();
    public void queryByBid(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String bid = request.getParameter("bid");

        if (bid == null || bid.equals("undefined") || bid.equals("0")) {
            bid = "5";
        }
        write(response, tDao.selectByBid(bid));

    }

    public void selectByBidWithReply(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String id = request.getParameter("id");

        if (id == null || id.equals("undefined")) {
            id = "5";
        }
        write(response, tDao.selectById(id));
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        //                        title: "",
        //                        content: "",
        //                        boardid: ""
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String boardid = request.getParameter("boardid");

        @SuppressWarnings("unchecked")
        Map<String,Object> map ;
        Object uid = 0;
        tBiz.add(title,content,boardid,uid);

    }
}