package dao;

import bean.SqMember;
import common.util.DBHelper;

import java.sql.SQLException;

public class UserDao {

    public void register(SqMember sqMember) throws SQLException {
        //INSERT INTO `sq_member` VALUES (1, 'sq', '1', '13888888888', 'sq@sq.com', NULL, NULL,
        // NULL, NULL, '2020-10-07 17:23:47');
        String sql = "insert into sq_member value (null,?,?,null,?,null,null,null,null,now()) ";
        DBHelper.update(sql,sqMember.getName(),sqMember.getPwd(),sqMember.getEmail());
    }
}
