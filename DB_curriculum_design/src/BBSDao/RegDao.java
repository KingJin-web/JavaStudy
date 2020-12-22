package BBSDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import   BBSBean.UserBean;

import   common.util.DBHelper;

public class RegDao {

	public void insert(UserBean user) throws SQLException {
		String sql="insert into tbl_user values(null,?,?,?,default,?)";
		DBHelper dbh=new DBHelper();
		
		dbh.update(sql, user.getUname(),
						user.getUpass(),
						user.getHead(),
						user.getGender()
				);	
	}
	
	/*
	 * public Map<String, Object> cheackUsername(String uname) throws SQLException{
	 * String sql=" tbl_user where uname=?"; DBHelper dbh=new DBHelper(); return
	 * dbh.selectOneMap(sql, uname); }
	 */
	
	public int cheakUsername(String uname) throws SQLException{
		String sql="select count(*) from tbl_user where uname=?";
		DBHelper dbh=new DBHelper();
		List<Integer> list=dbh.selectList(sql, new DBHelper.ResultSetMapper<Integer>() {

			@Override
			public Integer map(ResultSet rs) throws SQLException {
				System.out.println(rs.getInt(1));
				return rs.getInt(1);
				
			}
		}, uname);
		System.out.println(list.get(0));
		return list.get(0);
		
	}
	
}
