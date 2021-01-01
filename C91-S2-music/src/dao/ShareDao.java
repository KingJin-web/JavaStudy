package dao;

import common.util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;



public class ShareDao {

	public List<Map<String, Object>> listshare(String name, String singers) throws SQLException {
		String sql = "SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	sq_share a\n" +
				"LEFT JOIN sq_member b ON a.member = b. NAME\n" +
				"LEFT JOIN (\n" +
				"	SELECT\n" +
				"		count(*) cnt,\n" +
				"		member\n" +
				"	FROM\n" +
				"		sq_share\n" +
				"	GROUP BY\n" +
				"		member\n" +
				") c ON b. NAME = c.member\n" +
				"WHERE\n" +
				"	a. NAME = ?\n" +
				"AND singers = ?";
		
		return DBHelper.selectListMap(sql, name, singers);
	}
	
	
	public List<Map<String, Object>> listsharedetail(int page) throws SQLException{
		int begin=(page-1)*15;
		String sql="SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	sq_share a\n" +
				"LEFT JOIN sq_member b ON a.member = b. NAME\n" +
				"LEFT JOIN (\n" +
				"	SELECT\n" +
				"		count(*) cnt,\n" +
				"		member\n" +
				"	FROM\n" +
				"		sq_share\n" +
				"	GROUP BY\n" +
				"		member\n" +
				") c ON b. NAME = c.member\n" +
				"LIMIT ?,\n" +
				" 15";
		return DBHelper.selectListMap(sql,begin);
	}
	/**
	 * 网友分享总条数
 
	 * @return
	 * @throws SQLException
	 */
	public int  listall() throws SQLException{	
		String sql="SELECT\n" +
				"	count(*) cnt\n" +
				"FROM\n" +
				"	sq_share a\n" +
				"LEFT JOIN sq_member b ON a.member = b. NAME\n" +
				"LEFT JOIN (\n" +
				"	SELECT\n" +
				"		count(*) cnt,\n" +
				"		member\n" +
				"	FROM\n" +
				"		sq_share\n" +
				"	GROUP BY\n" +
				"		member\n" +
				") c ON b. NAME = c.member";
		List<Integer> list=DBHelper.selectList(sql, new DBHelper.ResultSetMapper<Integer>() {

			@Override
			public Integer map(ResultSet rs) throws SQLException {
				
				return rs.getInt(1);
			}
		});
		return list.get(0);
	}
	
	/**
	 * share 排行
	 * @throws SQLException 
	 */
	public List<Map<String, Object>> listph() throws SQLException{
		String sql="SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	sq_member b\n" +
				"RIGHT JOIN (\n" +
				"	SELECT\n" +
				"		count(*) cnt,\n" +
				"		member\n" +
				"	FROM\n" +
				"		sq_share\n" +
				"	GROUP BY\n" +
				"		member\n" +
				") a ON b. NAME = a.member\n" +
				"ORDER BY\n" +
				"	cnt DESC";
		
		return DBHelper.selectListMap(sql);
	}

	public List<Map<String, Object>> listrmzy() throws SQLException{
		String sql="select * from sq_share limit 66,12";
		
		return DBHelper.selectListMap(sql);
	}

}
