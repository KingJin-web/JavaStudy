package dao;

import common.util.DBHelper;

import java.sql.SQLException;



public class ZanDao {

	public void zanadd(String name ) throws SQLException {
		String sql="update sq_zan set totalzan=totalzan+1 where singername=?";

		DBHelper.update(sql);
	}
}
