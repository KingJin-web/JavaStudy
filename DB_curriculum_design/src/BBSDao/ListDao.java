package BBSDao;

import java.sql.SQLException;
import java.util.List;

import common.util.DBHelper;

public class ListDao {

	public List<?> queryList(String bid) {
		String sql = "SELECT\n" +
				"	*\n" +
				"FROM\n" +
				"	tbl_topic a\n" +
				"JOIN tbl_user b ON a.uid = b.id\n" +
				"LEFT JOIN (\n" +
				"	SELECT\n" +
				"		topicid,\n" +
				"		count(*) cnt \n" +
				"	FROM\n" +
				"		tbl_reply\n" +
				"	WHERE\n" +
				"		topicid = 1\n" +
				"	GROUP BY\n" +
				"		topicid\n" +
				") c ON a.id = c.topicid\n"+
				"where a.boardid=?" 
				;
		DBHelper dbh=new DBHelper();
		try {
			return dbh.selectListMap(sql,bid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<?> selectByIdWithReply(String id) {
		String sql = "select * from (SELECT\n" + 
				"	*\n" +
				"FROM\n" +
				"	tbl_topic\n" +
				"WHERE\n" + 
				"	id = ?\n"+
				"UNION ALL\n" +
				"	SELECT\n" + 
				"		*\n" + 
				"	FROM\n" + 
				"		tbl_reply\n" +
				"	WHERE\n"+
				"		topicid = ?)\n" +
				"a\n" +
				"JOIN tbl_user b ON a.uid = b.id";
		DBHelper dbh = new DBHelper();
		try {
			return dbh.selectListMap(sql, id, id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	 
	  public void insert(String title,String content,Object uid,String boardid ) throws SQLException {
		  String sql="insert into tbl_topic values(null,?,?,now(),null,?,?)";
		  DBHelper dbh=new DBHelper();
		  dbh.update(sql, title,content ,uid,boardid);
	  }
	  
}
