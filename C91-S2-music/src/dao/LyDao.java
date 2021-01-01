package dao;

import common.util.DBHelper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class LyDao {

    public void addly(String name, String content) throws SQLException {
        String sql = "insert into sq_ly values(null,?,?,null,now())";

        DBHelper.update(sql, name, content);
    }

    public List<Map<String, Object>> listly() throws SQLException {
        String sql = "select * from sq_ly";

        return DBHelper.selectListMap(sql);

    }
}
