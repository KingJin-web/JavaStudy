package BBSBiz;

import java.sql.SQLException;

import BBSDao.ListDao;
import common.biz.BizException;
import common.util.*;

public class TopicBiz {

	private ListDao ld=new ListDao();
	public void add(String title,String content,Object uid,String boardid ) throws BizException {
		Utils.checkNull(title, "标题不能为空");
		Utils.checkNull(content, "内容不能为空");
		
		try {
			ld.insert(title, content, uid, boardid);
		} catch (SQLException e) {
			throw new BizException("系统繁忙 请稍后再试");
		}
	}
}
