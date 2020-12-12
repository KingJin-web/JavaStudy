package D1201.biz;

import D1201.bean.User;
import D1201.dao.UserDao;

import java.sql.SQLException;

public class UserBiz {
    private UserDao udao = new UserDao();

    public void register(User user) throws BizException {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new BizException("请填写用户名");
        }
        if (udao.countByName(user.getName()) > 1) {
            throw new BizException("请填写用户名");
        }
        try {
            udao.insert(user);
        } catch (Exception ignored) {
            throw new BizException("系统繁忙，稍后再试！");
        }


    }
}
