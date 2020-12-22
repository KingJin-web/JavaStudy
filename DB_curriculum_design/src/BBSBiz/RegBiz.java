package BBSBiz;

import java.sql.SQLException;

import BBSBean.UserBean;
import BBSDao.RegDao;
import common.biz.BizException;

public class RegBiz {

	private RegDao rd = new RegDao();

	public void create(UserBean user, String repupass) throws BizException {
		if (user.getUname() == null || user.getUname().trim().isEmpty()) {
			throw new BizException("用户名不能为空");
		}
		if (user.getUpass() == null || user.getUpass().trim().isEmpty()) {
			throw new BizException("密码不能为空");
		}
		if (repupass == null || repupass.trim().isEmpty()) {
			throw new BizException("确认密码为空");
		}
		if (user.getUpass().equals(repupass)==false) {
			throw new BizException("确认密码有误");
		}
		try {
			int cnt = rd.cheakUsername(user.getUname());
			if (cnt > 0) {
				throw new BizException("用户已存在 请重试");
			}
		} catch (SQLException e1) {
			throw new BizException("系统繁忙,请稍等", e1);
		}
		
		/*
		 * try { 
		 * 		Map<String,Object> map=rd.cheackUsername(user.getUname());
		 * 		if(map.size()!=0) { 
		 * 			throw new BizException("该用户名已存在 请重新输入用户名"); 
		 * 		} 
		 * } catch(SQLException e1) { 
		 * throw new BizException("系统繁忙 请稍后再试11");
		 *  }
		 */

		try {
			rd.insert(user);
		} catch (SQLException e) {
			throw new BizException("系统繁忙 请稍后再试");
		}
	}

}
