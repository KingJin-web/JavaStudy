package dao;

import util.DBHelper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class TopicDao {
    public List<Map<String, Object>> selectByBid(String bid) throws SQLException {
        String sql = "SELECT\n" +
                "	* \n" +
                "FROM\n" +
                "	tbl_topic a\n" +
                "	LEFT JOIN tbl_user b ON a.uid = b.id\n" +
                "	LEFT JOIN ( SELECT topicid, count(*) cnt FROM tbl_reply WHERE topicid = 1 GROUP BY topicid ) c ON a.id = c.topicid"
                + " where a.boardid=?";


        return DBHelper.selectListMap(sql, bid);


    }


    public List<Map<String, Object>> selectById(String id) {
        String sql = "SELECT\n" +
                "	* \n" +
                "FROM\n" +
                "	( SELECT * FROM tbl_topic WHERE id = ? UNION ALL SELECT * FROM tbl_reply WHERE topicid = ? ) a\n" +
                "	JOIN tbl_user b ON a.uid = b.id";

        try {
            return DBHelper.selectListMap(sql,id,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insert(){
        String sql = "insert ";
    }
}
