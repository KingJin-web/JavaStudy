package dao;

import bean.DygCategory;
import util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DyDao {
    public List<DygCategory> selectAll(){
        String sql = "select * from dyg_category";

        return DBHelper.select(sql, new DBHelper.ResultSetMapper<DygCategory>() {
            @Override
            public DygCategory map(ResultSet rs) throws SQLException {
                DygCategory dy = new DygCategory();
                dy.setId(rs.getInt("id"));
                dy.setName(rs.getString("name"));
                dy.setSn(rs.getString("sn"));
                return dy;
            }
        });
    }

    public static void main(String[] args) {
        DyDao dyDao = new DyDao();
        System.out.println(dyDao.selectAll());
    }
}
