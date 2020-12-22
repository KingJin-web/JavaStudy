package BBSBiz;

import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisBiz {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.98.33.64");
        // 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
        //jedis.auth("aaa");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
    }

    RegBiz biz = new RegBiz();
    JedisPool JedisPool = new JedisPool("47.98.33.64");
    public void aVoid() {
        JedisPool jedis = new JedisPool("47.98.33.64");

        System.out.println("连接成功");

    }

    public void zan(String topicid, String uid) {
        Jedis jedis = JedisPool.getResource();
        try {
            String key = "topic_zan_" + topicid;
            jedis.hincrBy("topic_zan_map", key, 1);
        } finally {
            jedis.close();
        }
    }

    public int getZan(String topicid) {
        Jedis jedis = new Jedis("47.98.33.64");
        try {
            String key = "topic_zan_" + topicid;
            String value = jedis.hget("topic_zan_map", key);
            return value == null ? 0 : Integer.parseInt(value);
        } finally {
            jedis.close();
        }
    }

    @Test
    public void test1() {
//        zan("1","1");
//        zan("1","2");
//        zan("1","3");
//        zan("2","1");

        Assert.assertEquals(3,getZan("1"));
        Assert.assertEquals(1,getZan("2"));
    }
}
