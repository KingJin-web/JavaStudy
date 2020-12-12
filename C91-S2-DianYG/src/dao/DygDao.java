package dao;

import bean.DygMovie;
import bean.DygMovieWithBLOBs;
import bean.DygMsg;
import util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DygDao {
    public List<DygMovie> selectIndexYs() {
        String sql = "SELECT * from dyg_movie where category='ys '"
                + " order by create_date desc limit 0,16";
        return DBHelper.select(sql, new DBHelper.ResultSetMapper<DygMovie>() {
            @Override
            public DygMovie map(ResultSet rs) throws SQLException {
                DygMovie dygMovie = new DygMovie();
                dygMovie.setId(rs.getInt("id"));
                dygMovie.setName(rs.getString("name"));
                dygMovie.setPoster(rs.getString("poster"));
                dygMovie.setCreateDate(rs.getInt("create_date"));
                return dygMovie;
            }
        });
    }

    public DygMovieWithBLOBs selectById(String id) {
        String sql = "SELECT * from dyg_movie where id=?";

        return DBHelper.select(sql, new DBHelper.ResultSetMapper<DygMovieWithBLOBs>() {
            @Override
            public DygMovieWithBLOBs map(ResultSet rs) throws SQLException {
                DygMovieWithBLOBs dm = new DygMovieWithBLOBs();
                dm.setId(rs.getInt("id"));
                dm.setName(rs.getString("name"));
                dm.setPoster(rs.getString("poster"));
                dm.setCreateDate(rs.getInt("create_date"));
                dm.setIntro(rs.getString("intro"));
                return dm;
            }
        }, id).get(0);
    }


    public void insertMsg(DygMsg msg) {
        String sql = "insert into dyg_msg values(null,? , ? , ? ,null,null,null)";
        DBHelper.update(sql, msg.getCreateName(), msg.getEmail(), msg.getContent());
    }

    public static void main(String[] args) {
        DygDao dyDao = new DygDao();
        DygMsg msg = new DygMsg();
        msg.setCreateName("123");msg.setEmail("123");msg.setContent("123");
//        System.out.println(dyDao.selectIndexYs());
//        System.out.println(dyDao.selectById("45586"));
        dyDao.insertMsg(msg);
    }

}
