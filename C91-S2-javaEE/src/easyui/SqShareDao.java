package easyui;

import util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqShareDao {
    private SqSharMapper sharMapper = new SqSharMapper();
    public List<SqShare> selectPage(int page) {

        int begin = (page - 1) * 10;
        String sql = "select * from sq_share limit ?,10";

        return DBHelper.select(sql, sharMapper, begin);

    }

    public List<SqShare> selectPage() {

        String sql = "select * from sq_share";

        return DBHelper.select(sql, sharMapper);

    }

    public List<SqShare> selectPage(int page, int pageNums) {

        int begin = (page - 1) * pageNums;
        String sql = "select * from sq_share limit ?,?";
        return DBHelper.select(sql, sharMapper, begin, pageNums);

    }

    /**
     * 获取总记录数
     *
     * @return
     */
    public int selectCount() {
        String sql = "select count(*) cnt from sq_share";
        List<Integer> list = DBHelper.select(sql, new DBHelper.ResultSetMapper<Integer>() {
            @Override
            public Integer map(ResultSet rs) throws SQLException {
                return rs.getInt("cnt");
            }
        });
        return list.get(0);

    }

}

class SqSharMapper implements DBHelper.ResultSetMapper<SqShare> {
    @Override
    public SqShare map(ResultSet rs) throws SQLException {
        SqShare sh = new SqShare();
        sh.setId(rs.getInt(1));
        sh.setName(rs.getString(2));
        sh.setSingers(rs.getString(3));
        sh.setType(rs.getString(4));


        return sh;
    }
}