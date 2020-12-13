package web;

import dao.BoardDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board.s")
public class BoardServlet extends BaseServlet {
    private BoardDao boardDao = new BoardDao();

    private void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
        write(response, boardDao.query());
    }
}
