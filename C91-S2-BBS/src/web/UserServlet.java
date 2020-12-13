package web;

import javax.servlet.annotation.WebServlet;

@WebServlet("/user.s")
public class UserServlet extends BaseServlet{
    public void query(){
        String sql = "select * from tb1_user";
    }
}
