package com.yc.vue.dyg.util;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.catalina.tribes.util.Arrays;

public class DBHelper {

	/**
	 * DBHelper 新内容 1. 加入配置文件 .properties java 属性文件 Propertes ==> Map 2. 引入实体类
	 * List<Map<String,Object>> selectList(sql,param...) Map map = list.get(0);
	 * ==> row map.get("字段名"); List<实体类>selectList(sql,params...) 3. 分页查询方法
	 */

	private static String driver;
	private static String url;
	private static String name;
	private static String pwd;

	/**
	 * 静态块，初始化
	 */
	static {
		try {
			// 读取配置文件 ==> 通过类加载器读取类路径里面的文件
			String path = "conn.properties";
			InputStream in = DBHelper.class.getResourceAsStream(path);
			// 创建集合对象
			Properties prop = new Properties();
			prop.load(in);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			name = prop.getProperty("name");
			pwd = prop.getProperty("pwd");
			Class.forName(driver);
		} catch (Exception e) {
			// 异常转型 + 抛出运行期异常
			// 块不能直接抛出编译器异常
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取连接对象
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, name, pwd);
	}

	/**
	 * 查询歌手数据
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            可变参数数组，sql语句中的参数
	 * @return
	 * @throws SQLException
	 * 
	 *             1. 泛型： 定义类或方法只能处理某一种类型的对象 2. 回调函数： ==》 回调接口
	 * 
	 *             doAjax( url, function(){
	 * 
	 *             })
	 * 
	 * 
	 * 
	 */
	public static <T> List<T> selectList(
			String sql, 
			ResultSetMapper<T> callback, 
			Object... params)
			throws SQLException {

		System.out.println("SQL：" + sql);
		System.out.println("参数：" + Arrays.toString(params));
		Connection conn = getConnection();
		try {
			// 创建语句对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 设置查询参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			// 执行语句
			ResultSet rs = ps.executeQuery();
			// 定义返回结果
			List<T> ret = new ArrayList<>();
			// while(rs.next());
			for (; rs.next();) {
				T t = callback.map(rs);
				ret.add(t);
			}
			return ret;
		} finally {
			conn.close();
		}
	}

	/**
	 * 回调接口， 泛型接口
	 * 
	 * @param <T>
	 */
	public static interface ResultSetMapper<T> {
		T map(ResultSet rs) throws SQLException;
	}
	
	public int update(String sql, Object...params)throws SQLException {
		System.out.println("SQL：" + sql);
		System.out.println("参数：" + Arrays.toString(params));
		Connection conn = getConnection();
		try {
			// 创建语句对象
			PreparedStatement ps = conn.prepareStatement(sql);
			// 设置查询参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			return ps.executeUpdate();
		} finally {
			conn.close();
		}
	}

}
