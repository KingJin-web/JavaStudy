package singer;

import com.google.gson.Gson;
import util.DBHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBHelper.ResultSetMapper;

public class SqSingerDao {
    private static int count = 0;
    private final SqSingerMapper sqlMapper = new SqSingerMapper();


    public List<SqSinger> selectPage() {

        String sql = "select * from sq_singer";
        return DBHelper.select(sql, sqlMapper);

    }

    public List<SqSinger> selectPage(int page) {

        int begin = (page - 1) * 10;
        String sql = "select * from sq_singer limit ?,10";

        return DBHelper.select(sql, sqlMapper, begin);

    }

    public List<SqSinger> selectPage(int page, int pageNums) {

        int begin = (page - 1) * pageNums;
        String sql = "select * from sq_singer limit ?,?";
        return DBHelper.select(sql, sqlMapper, begin, pageNums);

    }

    /**
     * 组合查询 返回歌手数目
     *
     * @param name
     * @param address
     * @param category
     * @return
     */
    public int selectCount(String name, String address, String category) {
        List<SqSinger> list1 = new ArrayList<>();
        List<Object> params = new ArrayList<>();

        String sql = "select * from sq_singer where 1 = 1 ";
        if (!name.equals("1")) {
            sql += "and name like ?";
            params.add("%" + name + "%");
        }
        if (!address.equals("1")) {
            sql += "and nation like ?";
            params.add("%" + address + "%");
        }
        if (!category.equals("1")) {
            sql += "and category = ?";
            params.add(category);
        }

        Object[] pArray = params.toArray();
        list1 = DBHelper.select(sql, sqlMapper, pArray);
        return list1.size();
    }

    /**
     * 组合查询
     *
     * @param page
     * @param pageNums
     * @param name
     * @param address
     * @param category
     * @return
     */
    public List<SqSinger> selectPage(int page, int pageNums, String name, String address, String category) {

        int begin = (page - 1) * pageNums;
        List<Object> params = new ArrayList<>();

        String sql = "select * from sq_singer where 1 = 1 ";
        if (!name.equals("1")) {
            sql += "and name like ?";
            params.add("%" + name + "%");
        }
        if (!address.equals("1")) {
            sql += "and nation like ?";
            params.add("%" + address + "%");
        }
        if (!category.equals("1")) {
            sql += "and category = ?";
            params.add(category);
        }
        sql += " limit ?,?";
        params.add(begin);
        params.add(pageNums);
        Object[] pArray = params.toArray();
        return DBHelper.select(sql, sqlMapper, pArray);
    }


    //返回歌手种类
    public String selectCategory() {

        String sql = "select distinct category from sq_singer";
        SqSingerCategory sqSingerCategory = new SqSingerCategory();
        Gson gson = new Gson();
        //System.out.println(gson.toJson(DBHelper.select(sql, sqSingerCategory)));
        return gson.toJson(DBHelper.select(sql, sqSingerCategory));


    }

    public void deleteSinger(String name) {
        //DELETE FROM runoob_tbl WHERE runoob_id=3;
        DBHelper db = new DBHelper();
        String sql = "delete from sq_singer where name = ?";
        db.update(sql, name);


    }

    public void deleteSingerById(String id) {

        DBHelper db = new DBHelper();
        String sql = "delete from sq_singer where id = ?";
        db.update(sql, id);


    }

    public void insert(SqSinger ss) {
        DBHelper db = new DBHelper();
        String sql = "insert into sq_singer (name, category, birthday, members) values( ?,?,?,?) ";
        db.update(sql, ss.getName(), ss.getCategory()
                , ss.getBirthday(), ss.getMembers());
    }

    public static void main(String[] args) {
        SqSingerDao sd = new SqSingerDao();
        System.out.println(sd.selectCategory());
    }

}

class SqSingerMapper implements ResultSetMapper<SqSinger> {
    @Override
    public SqSinger map(ResultSet rs) throws SQLException {
        SqSinger sq = new SqSinger();
        sq.setId(rs.getInt(1));
        sq.setName(rs.getString(2));
        sq.setCategory(rs.getString(3));
        sq.setMembers(rs.getString(4));
        sq.setNation(rs.getString(5));
        sq.setBirthday(rs.getString(6));

        sq.setHead(rs.getString(8));

        return sq;
    }
}

class SqSingerCategory implements ResultSetMapper<SqSinger> {
    @Override
    public SqSinger map(ResultSet rs) throws SQLException {
        SqSinger sq = new SqSinger();
        sq.setCategory(rs.getString(1));
        return sq;
    }
}
