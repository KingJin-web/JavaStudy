package BBSBean;

import com.sun.jmx.snmp.Timestamp;

public class UserBean {

	private Integer id;
	private String uname;
	private String upass;
	private String head;
	private Timestamp regtime;
	private Integer gender;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Timestamp getRegtime() {
		return regtime;
	}
	public void setRegtime(Timestamp regtime) {
		this.regtime = regtime;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", uname=" + uname + ", upass=" + upass + ", head=" + head + ", regtime="
				+ regtime + ", gender=" + gender + "]";
	}
	
	
}
