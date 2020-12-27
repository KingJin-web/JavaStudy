package biz;

import bean.SqMember;
import common.biz.BizException;
import common.util.Utils;
import dao.UserDao;

import java.sql.SQLException;

public class UserBiz {
    private final UserDao userDao = new UserDao();

    public void InsertUser(SqMember sqMember) throws BizException {
        Utils.checkNull(sqMember.getName(), "请输入用户名");
        Utils.checkNull(sqMember.getPwd(), "请输入密码");
        Utils.checkNull(sqMember.getEmail(), "请输入邮箱");
        try {
            userDao.register(sqMember);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void loginBiz(SqMember sqMember) throws BizException {
        Utils.checkNull(sqMember.getName(), "请输入用户名");
        Utils.checkNull(sqMember.getPwd(), "请输入密码");

        try {
            int i = userDao.login(sqMember);
            if (i != 1) {
                throw new BizException("用户或密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws BizException {
        UserBiz userBiz = new UserBiz();
        SqMember sqMember = new SqMember();
        sqMember.setName("King");
        sqMember.setPwd("aaa");
        sqMember.setEmail("aaa");
        userBiz.InsertUser(sqMember);
    }

    public SqMember queryByName(String name) {
        SqMember sqMember = null;
        try {
            sqMember = userDao.selectByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sqMember;
    }
}
