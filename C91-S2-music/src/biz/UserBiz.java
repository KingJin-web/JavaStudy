package biz;

import bean.SqMember;
import common.biz.BizException;
import common.util.Utils;
import dao.UserDao;

import java.sql.SQLException;

public class UserBiz {
    private final UserDao userDao = new UserDao();

    public void InsertUser(SqMember sqMember) throws BizException {
        Utils.nameIsUse(sqMember.getName());
        Utils.checkNull(sqMember.getPwd(), "请输入密码");
        Utils.isEmail(sqMember.getEmail(), "请输入合法邮箱");
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

    /**
     * 通过用户名查询用户信息
     * @param name
     * @return
     */
    public SqMember queryByName(String name) {
        SqMember sqMember = null;
        try {
            sqMember = userDao.selectByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert sqMember != null;
        sqMember.setPwd("");
        return sqMember;
    }

    public void SendMail(String email, String vcode) throws BizException {
        Utils.isEmail(email, "请输入合法邮箱");
    }

    /**
     * 修改用户信息
     * @param sqMember
     */
    public void change(SqMember sqMember) throws BizException {

        Utils.checkNull(sqMember.getNickname(),"请输入昵称");
        Utils.isPhone(sqMember.getPhone());
        Utils.isEmail(sqMember.getEmail(),"请输入合法有效");
        Utils.isQq(sqMember.getQq());
        try {
            userDao.updateById(sqMember);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
