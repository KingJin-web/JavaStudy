package web;

import biz.DzBiz;
import common.web.BaseServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/zan.s")
public class ZanServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DzBiz db=new DzBiz();
	
	public void addzan(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name=request.getParameter("name");
		int uid=1;
		
		try {
			 db.zanadd(name, uid);
			write(response,"点赞成功");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	public void getzan(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String name=request.getParameter("name");
		try {
			write(response,db.getzan(name));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
	}
}
