package dao;

import bean.SqMember;
import common.util.DBHelper;
import common.util.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void register(SqMember sqMember) throws SQLException {

        String sql = "insert into sq_member value (null,?,?,?,null,?,null,null,null,null,now()) ";
        DBHelper.update(sql, sqMember.getName(), Utils.generateName(),
                sqMember.getPwd(), sqMember.getEmail());
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

    /**
     * 查询用户名注册人数
     *
     * @param name
     * @return
     * @throws SQLException
     */
    public int selectNumByName(String name) throws SQLException {
        String sql = "select count(*) from sq_member where name=? ";
        return DBHelper.selectList(sql, new DBHelper.ResultSetMapper<Integer>() {
            @Override
            public Integer map(ResultSet rs) throws SQLException {
                return rs.getInt(1);
            }
        }, name).get(0);
    }

    /**
     * id: 0,
     * name: "",
     * phone: "",
     * email: "",
     * qq: "",
     * head: "",
     * rank: "",
     * glod: "",
     * create_time: ""
     *
     * @param name
     * @return
     * @throws SQLException
     */
    public SqMember selectByName(String name) throws SQLException {
        String sql = "select * from sq_member where name = ?";
        return DBHelper.selectListBean(sql, SqMember.class, name).get(0);
    }

    /**
     * UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
     *
     * @param sqMember
     * @throws SQLException
     */
    public void updateById(SqMember sqMember) throws SQLException {
        String sql = "update sq_member set nickname = ? , phone=? , email =? , qq=? where id = ?";
        DBHelper.update(sql, sqMember.getNickname(), sqMember.getPhone(), sqMember.getEmail(), sqMember.getQq(), sqMember.getId());
    }
}
