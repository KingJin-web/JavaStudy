package D1201.util;

//import singer.SqSinger;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DBHelper {
    private static final String url;
    private static final String user;
    private static final String pwd;
    private static final String driver;

    static {
        try {
            String path = "util/conn.properties";
            InputStream in = DBHelper.class.getClassLoader().getResourceAsStream(path);
            Properties props = new Properties();
            props.load(in);
            /// System.out.println(props);
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            user = props.getProperty("user");
            pwd = props.getProperty("pwd");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static void main(String[] args) throws SQLException {
//
///*        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/db_1?serverTimezone=GMT%2B8";
//            String user = "root";
//            String pwd = "aaaa";
//            Connection conn = DriverManager.getConnection(url, user, pwd);
//            String sql = "select * from sq_singer";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                System.out.println(rs.getString(2));
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//*/
//
//        //select("select * from sq_singer");
//        List<SqSinger> list = select("select * from sq_singer", new ResultSetMapper<SqSinger>() {
//            @Override
//            public SqSinger map(ResultSet rs) throws SQLException {
//                SqSinger sq = new SqSinger();
//                sq.setId(rs.getInt(1));
//                sq.setName(rs.getString(2));
//                sq.setCategory(rs.getString(3));
//                sq.setMembers(rs.getString(4));
//                sq.setNation(rs.getString(5));
//                sq.setBirthday(rs.getString(6));
//                sq.setIntro(rs.getString(7));
//                sq.setHead(rs.getString(8));
//                sq.setLikes(rs.getInt(9));
//                return sq;
//            }
//        });
//        System.out.println(list);
//    }
//
//    public static List<SqSinger> select(String sql, Object... params) {
//
//        System.out.println("sql " + sql);
//        System.out.println("参数" + Arrays.toString(params));
//        Connection conn = getConnection();
//        List<SqSinger> list = new ArrayList<>();
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            for (int i = 0; i < params.length; i++) {
//                ps.setObject(i, params[i]);
//            }
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SqSinger sq = new SqSinger();
//                sq.setId(rs.getInt(1));
//                sq.setName(rs.getString(2));
//                sq.setCategory(rs.getString(3));
//                sq.setMembers(rs.getString(4));
//                sq.setNation(rs.getString(5));
//                sq.setBirthday(rs.getString(6));
//                sq.setHead(rs.getString(8));
//                list.add(sq);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            IOHelper.close(conn);
//        }
//        for (SqSinger sqSinger : list) {
//            System.out.println(sqSinger);
//        }
//        return list;
//    }

    public static <T> List<T> select(String sql, ResultSetMapper<T> callback, Object... params) {

        System.out.println("sql " + sql);
        System.out.println("参数" + Arrays.toString(params));
        Connection conn = getConnection();
        List<T> ret = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                T t = callback.map(rs);
                ret.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            IOHelper.close(conn);
        }
        return ret;
    }

    /**
     * 执行修改数据库的语句
     * sql = "update emp set ename = ? where empno=?"
     * update(sql,2,3,)
     *
     * @param sql    执行的sql语句
     * @param params 可变参数数组
     * @return
     */
    public int update(String sql, Object... params) {
        Connection conn = null;
        try {
            // 每次都会通过open方法获取连接
            conn = getConnection();
            System.out.println("SQL: " + sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            // alrt + /
            System.out.println("参数: " + Arrays.toString(params));
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("执行SQL语句失败!", e);
        } finally {
            IOHelper.close(conn);
        }
    }

    /**
     * 回调接口
     *
     * @param <T>
     */
    public interface ResultSetMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }
}
