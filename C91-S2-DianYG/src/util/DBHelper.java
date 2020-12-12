package util;



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
    public static int update(String sql, Object... params) {
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
