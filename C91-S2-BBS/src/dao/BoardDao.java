package dao;

import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class BoardDao {
//    public List<?> query(){
//        String sql = "select * from tbl_board";
//        try {
//            return DBHelper.selectListMap(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    public List<?> query(){
        String sql = "SELECT\n" +
                "	a.*,\n" +
                "	b.*,\n" +
                "	c.title,\n" +
                "	d.uname,\n" +
                "	c.publishtime \n" +
                "FROM\n" +
                "	tbl_board a\n" +
                "	LEFT JOIN ( SELECT boardid, count(*) cnt FROM tbl_topic GROUP BY boardid ) b ON a.id = b.boardid\n" +
                "	LEFT JOIN ( SELECT * FROM tbl_topic a WHERE a.id IN ( SELECT max( id ) FROM tbl_topic GROUP BY boardid ) ) c ON a.id = c.boardid\n" +
                "	LEFT JOIN tbl_user d ON d.id = c.uid"
                ;
        try {
            return DBHelper.selectListMap(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
