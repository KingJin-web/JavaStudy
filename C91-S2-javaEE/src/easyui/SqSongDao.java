package easyui;

import util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqSongDao {
    SqSongMapper sonMapper = new SqSongMapper();

    public List<SqSong> selectPage(int page) {

        int begin = (page - 1) * 10;
        String sql = "select * from sq_song limit ?,10";

        return DBHelper.select(sql, sonMapper, begin);

    }

    public List<SqSong> selectPage() {

        String sql = "select * from sq_song";

        return DBHelper.select(sql, sonMapper);

    }

    public List<SqSong> selectPage(int page, int pageNums) {

        int begin = (page - 1) * pageNums;
        String sql = "select * from sq_song limit ?,?";
        return DBHelper.select(sql, sonMapper, begin, pageNums);

    }

    /**
     * 获取总记录数
     *
     * @return
     */
    public int selectCount() {
        String sql = "select count(*) cnt from sq_song";
        List<Integer> list = DBHelper.select(sql, new DBHelper.ResultSetMapper<Integer>() {
            @Override
            public Integer map(ResultSet rs) throws SQLException {
                return rs.getInt("cnt");
            }
        });
        return list.get(0);

    }

}

class SqSongMapper implements DBHelper.ResultSetMapper<SqSong> {
    @Override
    public SqSong map(ResultSet rs) throws SQLException {
        SqSong so = new SqSong();
        so.setId(rs.getInt(1));
        so.setName(rs.getString(2));
        so.setSinger(rs.getString(3));
        so.setType(rs.getString(4));
        so.setSize(rs.getString(5));
        so.setHeat(rs.getInt(6));

        return so;
    }
}