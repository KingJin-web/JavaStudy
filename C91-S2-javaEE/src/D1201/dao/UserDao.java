package D1201.dao;


import D1201.bean.User;
import D1201.util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao {
    private final DBHelper dbHelper = new DBHelper();

    public void insert(User user) {
        String sql = "insert into user value (null,?,?,?,?,?,default)";
        dbHelper.update(sql, user.getName(),
                user.getPhone(),
                user.getEmail(),
                user.getPwd(),
                user.getHead());
    }

    public int countByName(String name) {
        String sql = "select count(*) from user where name = ?";
        List<Integer> list = DBHelper.select(sql, new DBHelper.ResultSetMapper<Integer>() {
            @Override
            public Integer map(ResultSet rs) throws SQLException {
                return rs.getInt(1);
            }
        },name);
        return list.get(0);
    }
}
