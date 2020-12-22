package BBSBiz;

import java.sql.SQLException;
import java.util.List;

import BBSBean.UserBean;
import BBSDao.LoginDao;
import common.biz.BizException;

public class LoginBiz {

	private LoginDao ld = new LoginDao();

	public UserBean BoardLogin(String uname, String upass) throws BizException {
		if (uname == null || uname.trim().isEmpty()) {
			throw new BizException("用户名不能为空");
		}
		if (upass == null || upass.trim().isEmpty()) {
			throw new BizException("密码不能为空");
		}
		try {
			List<UserBean> list = ld.Login(uname, upass);
			if (list.size() == 0) {
				throw new BizException("用户名或密码错误");
			}
			System.out.println(list.get(0));
			return list.get(0);
		} catch (SQLException e) {
			throw new BizException("系统繁忙 请联系管理员");
		}
	}

}
