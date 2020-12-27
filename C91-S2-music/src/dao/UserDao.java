package dao;

import bean.SqMember;
import common.util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void register(SqMember sqMember) throws SQLException {

        String sql = "insert into sq_member value (null,?,?,null,?,null,null,null,null,now()) ";
        DBHelper.update(sql, sqMember.getName(), sqMember.getPwd(), sqMember.getEmail());
    }

    public int login(SqMember sqMember) throws SQLException {
        String sql = "select count(*) from sq_member where name=? and pwd =?";

        return DBHelper.selectList(sql, new DBHelper.ResultSetMapper<Integer>() {
            @Override
            public Integer map(ResultSet rs) throws SQLException {
                return rs.getInt(1);
            }
        }, sqMember.getName(), sqMember.getPwd()).get(0);
    }

    public SqMember selectByName(String name) throws SQLException {
        String sql = "select * from sq_member where name = ?";
        return DBHelper.selectListBean(sql, SqMember.class, name).get(0);
    }
}
