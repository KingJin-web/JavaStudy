package bean;

import java.sql.Timestamp;

public class DygMsg {
    private Integer id;

    private String content;

    private String reply;

    private String replyTime;
    private String createName;

    private Timestamp createTime;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DygMsg{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", reply='" + reply + '\'' +
                ", replyTime='" + replyTime + '\'' +
                ", createName='" + createName + '\'' +
                ", createTime=" + createTime +
                ", email='" + email + '\'' +
                '}';
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}