package biz;

import redis.clients.jedis.Jedis;

public class DzBiz {
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis(); // 默认访问本机6379
		try{
			System.out.println(jedis.keys("*"));
		} finally {
			jedis.close();
		}
	}
	
	public void zanadd(String name,int uid) {
		Jedis j=new Jedis();
		
		try{
			String key  = "singer" + name;
			// 点赞数 + 1
			j.hincrBy("singer_zan_map", key, 1);
		} finally {
			j.close();
		}
		
	}
	public int getzan(String name) {
		Jedis j=new Jedis();
		
		try{
			String key  = "singer" + name;
			// 点赞数 + 1
			String value = j.hget("singer_zan_map", key);
			return value == null ? 0 : Integer.parseInt(value);
		} finally {
			j.close();
		}
		
	}
	
}
