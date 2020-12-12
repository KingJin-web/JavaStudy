package biz;


import bean.DygMsg;
import dao.DygDao;

public class MsgBiz {

    private final DygDao dygDao = new DygDao();

    public void addMsg(DygMsg msg) throws BizException {
        if (msg.getCreateName() == null || msg.getCreateName().isEmpty() || msg.getCreateName().equals("undefined")) {
            throw new BizException("请填写用户名");
        }
        if (msg.getEmail() == null || msg.getEmail().isEmpty() || msg.getEmail().equals("undefined")) {
            throw new BizException("留言人的邮箱地址未填写! ");
        }
        if (msg.getContent() == null || msg.getContent().isEmpty() || msg.getContent().equals("undefined")) {
            throw new BizException("留言的内容未填写! ");
        }
        try {
            dygDao.insertMsg(msg);
        } catch (Exception ignored) {
            throw new BizException("系统繁忙，稍后再试！");
        }


    }
}
