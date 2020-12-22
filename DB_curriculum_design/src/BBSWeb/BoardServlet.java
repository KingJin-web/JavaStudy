package BBSWeb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BBSBiz.TopicBiz;
import BBSDao.BoardDao;
import BBSDao.ListDao;
import common.bean.Result;
import common.biz.BizException;
import common.web.BaseServlet;
@WebServlet("/board.s")
public class BoardServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TopicBiz tb=new TopicBiz();
	private BoardDao bdao=new BoardDao();
	private ListDao ld=new ListDao();
	public void query(HttpServletRequest request,HttpServletResponse response) {
		try {
			write(response, bdao.query());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void querylist(HttpServletRequest request,HttpServletResponse response) {
		String bid=request.getParameter("bid");
		try {
			write(response, ld.queryList(bid));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void querybyidwithreply(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		try {
			write(response, ld.selectByIdWithReply(id));
		} catch (IOException e) {
			// TODO Auto-generated
			e.printStackTrace();
		}
	}
	 
	
	public void add(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String boardid=request.getParameter("boardid");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		int uid=(int) request.getSession().getAttribute("usercount");
		System.out.println(uid);
		/* Object uid=1; */
		try {
			tb.add(title, content, uid, boardid);
			write(response, Result.success("发帖成功"));
		} catch (BizException e) {
			e.printStackTrace();
			write(response, Result.failure("发帖失败"+e.getMessage()));
		}
	}
	
	
}
