package biz;

import bean.SqMember;
import common.biz.BizException;
import common.util.Utils;
import dao.UserDao;

import java.sql.SQLException;

public class UserBiz {
    private final UserDao userDao = new UserDao();

    public void InsertUser(SqMember sqMember) {

        try {
            Utils.checkNull(sqMember.getName(), "");
            Utils.checkNull(sqMember.getPwd(), "");
            Utils.checkNull(sqMember.getEmail(), "");
            userDao.register(sqMember);
        } catch (BizException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        UserBiz userBiz = new UserBiz();
        SqMember sqMember = new SqMember();
        sqMember.setName("King");
        sqMember.setPwd("aaa");
        sqMember.setEmail("aaa");
        userBiz.InsertUser(sqMember);
    }
}
